package org.nix.movieticketingsystem.commons.utils.file;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 * <p>
 * 文件处理工具类
 */

public class FileUtil {

    private static Logger logger = Logger.getLogger(FileUtil.class);

    private FileUtil() {
    }

    public static boolean write(MultipartFile file, String path) throws IOException {

        if (!file.isEmpty()) {

            path += file.getOriginalFilename();

            BufferedOutputStream buffer = new BufferedOutputStream(
                    new FileOutputStream(
                            new File(path)));

            buffer.write(file.getBytes());
            buffer.flush();
            buffer.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将文件写入到服务器中
     *
     * @param file    上传文件
     * @param request 用户请求
     * @return 是否操作成功
     * @throws IOException 写入文件异常
     */
    public static String write(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileTye = fileName.substring((fileName.lastIndexOf('.') + 1));
        String path = request.getSession().getServletContext().getRealPath(fileTye) + fileName;
        logger.info("fileName : " + fileName + "\n" +
                "fileType : " + fileTye + "\n" +
                "path : " + path);
        if (write(file, path)){
            return path;
        }else {
            return null;
        }
    }

    /**
     * 通过文件路径获取文件名
     * @param path 文件完整路径
     * @return 文件名
     */
    public static String getFileNameByPath(String path) {
        return path.substring(path.lastIndexOf("\\") + 1);
    }


}
