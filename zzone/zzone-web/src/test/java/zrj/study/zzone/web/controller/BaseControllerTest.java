package zrj.study.zzone.web.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
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
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.Map;

import static org.mockito.BDDMockito.*;
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
    protected String account = "admin";
    protected String password = "admin";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CodeService codeService;

    @Autowired
    private KeyService keyService;

    protected void initBaseModel(BaseModel model) {
        model.setMacId(macId);
        model.setSource(source);
    }

    protected ResultActions postJsonLogin(String url, Object object) throws Exception {
        if (StringUtils.isBlank(token)) {
            login();
        }
        return postJsonUnlogin(url, object);
    }

    protected ResultActions postJsonUnlogin(String url, Object object) throws Exception {
        return postJsonUnloginIgnoreCode(url, object)
                .andExpect(jsonPath("$.code").value(Result.SUCCESS));
    }

    protected ResultActions postJsonUnloginIgnoreCode(String url, Object object) throws Exception {
        MockHttpServletRequestBuilder configureRequest = post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(null != object ? JsonUtils.toJsonString(object) : "");
        if (StringUtils.isNotBlank(token)) {
            configureRequest.header("token", token);
        }
        return this.mockMvc.perform(configureRequest)
                .andDo(print()).andExpect(status().isOk());
    }

    protected Result getResult(ResultActions resultActions) throws IOException {
        return JsonUtils.parseToObject(resultActions.andReturn().getResponse().getContentAsString(), Result.class);
    }

    @Test
    public void login() throws Exception {
        UserModel userModel = new UserModel();
        initBaseModel(userModel);
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        userModel.setUser(user);

        ResultActions resultActions = postJsonUnlogin("/login", userModel);
        Map content = (Map) getResult(resultActions).getContent();
        token = content.get("token").toString();
    }

    protected String getCodeTxt() throws Exception {
        CodeModel codeModel = new CodeModel();
        initBaseModel(codeModel);
        Code code = new Code();
        code.setHeight(100);
        code.setWidth(100);
        codeModel.setCode(code);
        postJsonUnloginIgnoreCode("/code/get", codeModel);
        return codeService.getCode(macId);
    }


    protected RSAKey getKey() throws Exception {
        return keyService.get(getFrontKey().get("keyId").toString());
    }

    protected Map getFrontKey() throws Exception {
        BaseModel baseModel = new BaseModel();
        initBaseModel(baseModel);
        ResultActions resultActions = postJsonUnlogin("/key/get", baseModel);
        return (Map) getResult(resultActions).getContent();
    }

    protected String encryptUseBCBase64(String srcText, RSAPublicKey pubKey) throws Exception {
        byte[] encryptedDataBC = RSAUtils.encryptUseBC(srcText.getBytes("UTF-8"), pubKey);
        return Base64.getEncoder().encodeToString(encryptedDataBC);
    }




    @Test
    public void hello() throws Exception {
        postJsonLogin("/hello", null);
    }

    @Test
    public void code() throws Exception {
        System.out.println(getCodeTxt());
    }

    @Test
    public void key() throws Exception {
        Map key = getFrontKey();

        String srcText = "钟如劼";
        byte[] pubKey = Base64.getDecoder().decode(key.get("pubKey").toString());
        // 加密useBC
        byte[] encryptedDataBC = RSAUtils.encryptUseBC(srcText.getBytes("UTF-8"), pubKey);

        // 解密useBC
        RSAKey priKey = keyService.get(key.get("keyId").toString());
        byte[] srcDataBC = RSAUtils.decryptUseBC(encryptedDataBC, priKey.getRsaPrivateKey());

        Assert.assertEquals(srcText, new String(srcDataBC, "UTF-8"));
    }

    @MockBean
    private MockTest test;

    @Test
    public void test() {
        given(this.test.test()).willReturn("mock");
        System.out.println(test.test());
    }


}
