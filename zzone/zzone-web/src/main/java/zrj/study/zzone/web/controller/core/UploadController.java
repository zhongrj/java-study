package zrj.study.zzone.web.controller.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import zrj.study.zzone.core.service.FileService;
import zrj.study.zzone.web.model.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 上传Controller
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/7
 */
@RestController
@RequestMapping("/core/upload/")
public class UploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/image")
    public Result image(@RequestParam(value = "images") MultipartFile[] images) throws Exception {
        Map<String, String> imageIds = new HashMap<>();
        for (MultipartFile image : images) {
            String imageId = fileService.storeImage(image.getBytes(), image.getOriginalFilename());
            imageIds.put(image.getOriginalFilename(), imageId);
        }
        return new Result(Result.SUCCESS, "上传成功", imageIds);
    }

}
