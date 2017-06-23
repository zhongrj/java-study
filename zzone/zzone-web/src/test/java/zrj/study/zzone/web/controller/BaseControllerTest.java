package zrj.study.zzone.web.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.json.JsonUtils;
import zrj.study.util.security.RSAUtils;
import zrj.study.util.string.StringUtils;
import zrj.study.zzone.core.entity.Code;
import zrj.study.zzone.core.entity.RSAKey;
import zrj.study.zzone.core.entity.User;
import zrj.study.zzone.core.service.CodeService;
import zrj.study.zzone.core.service.KeyService;
import zrj.study.zzone.web.ZzoneApplication;
import zrj.study.zzone.web.model.BaseModel;
import zrj.study.zzone.web.model.Result;
import zrj.study.zzone.web.model.core.CodeModel;
import zrj.study.zzone.web.model.core.UserModel;

import java.io.IOException;
import java.io.InputStream;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Map;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Import(ZzoneApplication.class)
@ActiveProfiles("dev-back")
@Transactional
public class BaseControllerTest {

    private String token;
    protected String macId = "00";
    protected String source = "web";
    protected String account = "user";
    protected String password = "user";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CodeService codeService;

    @Autowired
    private KeyService keyService;

    /**
     * 为model添加全局参数
     *
     * @param model model
     */
    protected void initBaseModel(BaseModel model) {
        model.setMacId(macId);
        model.setSource(source);
    }

    /**
     * 设为管理员
     */
    protected void suAdmin() {
        account = "admin";
        password = "admin";
    }

    /**
     * 登录(带token) post请求
     *
     * @param url    url
     * @param object 请求实体
     * @return ResultActions
     */
    protected ResultActions postJsonLogin(String url, Object object) throws Exception {
        if (StringUtils.isBlank(token)) {
            login();
        }
        MockHttpServletRequestBuilder configureRequest = getBaseRequestBuilder(url, object);
        configureRequest.header("token", token);
        return this.mockMvc.perform(configureRequest)
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(Result.SUCCESS));
    }

    /**
     * 不登录(不带token) post请求
     *
     * @param url    url
     * @param object 请求实体
     * @return ResultActions
     */
    protected ResultActions postJsonUnlogin(String url, Object object) throws Exception {
        return this.mockMvc.perform(getBaseRequestBuilder(url, object))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(Result.SUCCESS));
    }

    /**
     * 不登录(不带token) 且 不校验响应code post请求
     *
     * @param url    url
     * @param object 请求实体
     * @return ResultActions
     */
    protected ResultActions postJsonSimply(String url, Object object) throws Exception {
        MockHttpServletRequestBuilder configureRequest = getBaseRequestBuilder(url, object);
        return this.mockMvc.perform(configureRequest).andExpect(status().isOk());
    }

    /**
     * 获得基础requestBuilder
     */
    private MockHttpServletRequestBuilder getBaseRequestBuilder(String url, Object object) throws Exception {
        return post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(null != object ? JsonUtils.toJsonString(object) : "");
    }

    /**
     * 将响应json转为Result
     *
     * @param resultActions 响应action
     * @return Result
     */
    protected Result getResult(ResultActions resultActions) throws IOException {
        return JsonUtils.parseToObject(resultActions.andReturn().getResponse().getContentAsString(), Result.class);
    }

    //@Test
    public void login() throws Exception {
        UserModel userModel = new UserModel();
        initBaseModel(userModel);
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        userModel.setUser(user);

        ResultActions resultActions = postJsonUnlogin("/core/user/login", userModel);
        Map content = (Map) getResult(resultActions).getContent();
        token = content.get("token").toString();
    }

    /**
     * 发送并获取验证码String
     */
    protected String getCodeTxt() throws Exception {
        CodeModel codeModel = new CodeModel();
        initBaseModel(codeModel);
        Code code = new Code();
        code.setHeight(100);
        code.setWidth(100);
        codeModel.setCode(code);
        postJsonSimply("/core/code/get", codeModel);
        return codeService.getCode(macId);
    }


    /**
     * 发送并获取rsa密钥（从keyService中获取）
     */
    protected RSAKey getKey() throws Exception {
        getPubKey();
        return keyService.get(macId);
    }

    /**
     * 发送并获取rsa公钥
     */
    protected String getPubKey() throws Exception {
        BaseModel baseModel = new BaseModel();
        initBaseModel(baseModel);
        ResultActions resultActions = postJsonUnlogin("/core/key/get", baseModel);
        return ((Map) getResult(resultActions).getContent()).get("pubKey").toString();
    }

    /**
     * 使用rsa公钥加密
     *
     * @param srcText 明文
     * @param pubKey  公钥
     * @return 密文
     */
    protected String encryptUseBCBase64(String srcText, RSAPublicKey pubKey) throws Exception {
        byte[] encryptedDataBC = RSAUtils.encryptUseBC(srcText.getBytes("UTF-8"), pubKey);
        return Base64.getEncoder().encodeToString(encryptedDataBC);
    }

    /**
     * 上传文件
     *
     * @param fileClasspath 文件路径（基于classpath）
     * @return 响应
     */
    public Result uploadFile(String uploadUri, String fileClasspath, String fileName) throws Exception {
        MockMultipartHttpServletRequestBuilder requestBuilder = fileUpload(uploadUri);
        InputStream is = new ClassPathResource(fileClasspath).getInputStream();
        requestBuilder.file(new MockMultipartFile("images", fileName, null, is));

        ResultActions resultActions = mockMvc.perform(requestBuilder)
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(Result.SUCCESS));

        return getResult(resultActions);
    }


    @MockBean
    private MockTest test;

    @Test
    public void test() {
        given(this.test.test()).willReturn("mock");
        System.out.println(test.test());
    }


}
