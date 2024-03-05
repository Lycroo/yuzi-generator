package com.yupi.generator;

import cn.hutool.core.util.ArrayUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator_2 {

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        String inputFile = property + File.separatorChar + "yuzi-generator-demo-projects" + File.separatorChar + "acm-template";
        String outputFile = property;
        copyFilesByRecursives(inputFile, outputFile);
    }

    public static void copyFilesByRecursives(String inputFile, String ouputFile) {
        File Infile = new File(inputFile);
        File OutFile = new File(ouputFile);
        try {
            copyFilesByRecursive(Infile, OutFile);
        } catch (IOException e) {
            System.out.println("文件创建失败!");
            e.printStackTrace();
        }
    }

    public static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {
        if (inputFile.isDirectory()) {
            File destFile = new File(outputFile, inputFile.getName());
            if (!destFile.exists()) {
                destFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                copyFilesByRecursive(file, destFile);
            }
        } else {
            Path resolve = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), resolve, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
