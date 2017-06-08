package zrj.study.zzone.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zrj.study.util.io.IOUtils;
import zrj.study.util.string.IdGen;
import zrj.study.zzone.core.common.exception.ZzoneException;
import zrj.study.zzone.core.dao.FileDao;
import zrj.study.zzone.core.entity.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/7
 */
@Service
@Transactional(readOnly = true)
public class FileService {

    @Autowired
    private FileDao fileDao;

    @Value("${upload.path.img}")
    private String IMAGE_STORE_PATH;
    private static final Pattern IMAGE_PATTERN = Pattern.compile("^.(jpg|jpeg|png|gif)$");

    @Transactional
    public String storeImage(byte[] bytes, String originalFileName) throws IOException {
        String suffix = IOUtils.getFileSuffix(originalFileName);
        if (!IMAGE_PATTERN.matcher(suffix).matches()) {
            throw new ZzoneException("非图片文件");
        }

        String uuid = IdGen.uuid();
        String storeName = uuid + IOUtils.getFileSuffix(originalFileName);
        IOUtils.write(bytes, IMAGE_STORE_PATH + IOUtils.SEPARATOR + storeName);

        File file = new File();
        file.setId(uuid);
        file.setOriginName(originalFileName);
        file.setStoreName(storeName);
//        file.setType("");       // 暂时没用type
        file.preInsert();
        fileDao.insert(file);
        return uuid;
    }

    public File getImage(String id) throws IOException {
        File file = fileDao.get(id);
        file.setInputStream(new FileInputStream(IMAGE_STORE_PATH + IOUtils.SEPARATOR + file.getStoreName()));
        return file;
    }
}
