package com.ben.quiz.domain.common.util;


import com.ben.quiz.domain.common.exception.QuizException;
import org.apache.commons.io.FileUtils;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileUtil {

    public static File getFileFromResources(String fileName) throws QuizException{
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        return file;
    }

    public static void uploadFileToOSPath(MultipartFile file, String path) throws QuizException {
        try {
            FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
        } catch (IOException e) {
            throw new QuizException(1, "Error while uploading file", e);
        }
    }


    public static void deleteFileInOSPath(String path) throws QuizException {
        if (Files.isDirectory(Paths.get(path))){
            System.out.println("exit");
            try {
                Files.deleteIfExists(Paths.get(path));
            } catch (IOException e) {
                throw new QuizException(1, "Error while deleting file", e);
            }
        }
    }

}