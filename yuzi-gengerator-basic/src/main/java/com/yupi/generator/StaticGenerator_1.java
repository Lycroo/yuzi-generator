package com.yupi.generator;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class StaticGenerator_1 {

    public static void main(String[] args) {

        String projectpath = System.getProperty("user.dir");
        String inputPath = projectpath + File.separatorChar +"yuzi-generator-demo-projects"+File.separatorChar+"acm-template";
        System.out.println("----------1------------");
        System.out.println(inputPath);
        copyFilesByRecursives(inputPath, projectpath);
    }


    public static void copyFilesByRecursives(String inputPath,String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFilesByRecursive(inputFile,outputFile);
        } catch (IOException e) {
            System.out.println("文件创建失败!");
           e.printStackTrace();
        }

    }

    public static void copyFilesByRecursive(File inputFile,File outPutFile) throws IOException {

        //目录和文件分开来判断
        if (inputFile.isDirectory()){
            File destFile = new File(outPutFile, inputFile.getName());
            if (!destFile.exists()){
                destFile.mkdirs();
            }
            File[] inputFilesList = inputFile.listFiles();
            if (ArrayUtil.isEmpty(inputFilesList)){
                return;
            }
            for (File file : inputFilesList) {
                copyFilesByRecursive(file,destFile);
            }
        }else {
            Path outPutFile1 = outPutFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),outPutFile1, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
