package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zrj.study.util.io.IOUtils;
import zrj.study.zzone.core.entity.File;
import zrj.study.zzone.core.service.FileService;
import zrj.study.zzone.web.controller.BaseController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 下载Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
@RestController
@RequestMapping("/download/")
public class DownloadController extends BaseController {

    @Autowired
    private FileService fileService;

    @RequestMapping("image")
    public void image(@RequestParam("id") String id, HttpServletResponse response) throws IOException {

        File file = fileService.getImage(id);
        IOUtils.copy(file.getInputStream(), response.getOutputStream());

//        response.setHeader("Pragma", "no-cache");         //怎么设缓存
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        response.setHeader("content-disposition",
                "attachment;filename=" + URLEncoder.encode(file.getStoreName(), "UTF-8"));

    }
}
