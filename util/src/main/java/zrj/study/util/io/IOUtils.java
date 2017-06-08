package zrj.study.util.io;

import java.io.*;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
public class IOUtils {

    public final static char SEPARATOR = '/';

    /**
     * 写文件
     * @param bytes 数据
     * @param filePath 文件路径
     */
    public static void write(byte[] bytes, String filePath) throws IOException {
        write(bytes, new FileOutputStream(filePath));
    }

    public static void write(byte[] bytes, OutputStream output) throws IOException {
        try {
            output.write(bytes);
        } finally {
            output.close();
        }
    }

    /**
     * 创建目录（如果不存在）
     * @param dirPath 目录路径
     */
    public static void createDirIfNotExist(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 创建文件及其目录（如果不存在）
     * @param filePath 文件路径
     */
    public static void createFileIfNotExist(String filePath) throws IOException {
        int lastSeparatorIndex = filePath.lastIndexOf(SEPARATOR);
        if (lastSeparatorIndex == -1) {
            throw new RuntimeException("路径不合法");
        }

        createDirIfNotExist(filePath.substring(0, lastSeparatorIndex));

        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * 获取文件后缀（包括.）
     * @param filePath 文件路径
     */
    public static String getFileSuffix(String filePath) {
        int lastSpotIndex = filePath.lastIndexOf('.');
        if (lastSpotIndex == -1) {
            throw new RuntimeException("文件路径不合法");
        }
        return filePath.substring(lastSpotIndex);
    }

    /**
     * 输入流拷贝至输出流
     * @param input 输入
     * @param output 输出
     */
    public static int copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];
        int count = 0, n;
        try{
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
                count += n;
            }
        } finally {
            input.close();
            output.close();
        }
        return count;
    }


    /**
     * 读取inputStream内容
     * @param input 输入流
     * @param charsetName 字符集
     */
    public static String getContent(InputStream input, String charsetName) throws IOException {
        StringBuffer sb = new StringBuffer();
        byte[] bytes = new byte[1024];
        int i = 0;
        try {
            while ((i = input.read(bytes)) > 0) {
                sb.append(new String(bytes, 0, i, charsetName));
            }
        } finally {
            input.close();
        }
        return sb.toString();
    }


    public static String replaceSeparator(String path) {
        if (null == path) {
            return null;
        }
        return path.replaceAll("\\", String.valueOf(SEPARATOR));
    }

    /**
     * 封装close方法
     * @param closeable
     */
    public static void close(Closeable closeable) {
        try {
            if(closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
        }
    }

}
