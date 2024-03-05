package com.yupi.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {
    public static void main(String[] args) {
        //获取根路径
        String projectpath = System.getProperty("user.dir");
    //   System.out.println(projectpath);
        System.out.println("-----*****------");
        //拼接要复制的文件
        String inputPath =projectpath+File.separatorChar+ "yuzi-generator-demo-projects"+ File.separatorChar +"acm-template";
      //  System.out.println(inputPath);
        //将复制的文件传到根目录
        String outputPath = projectpath;
        CopyFilesByHutools(inputPath,outputPath);
    }

    public static void CopyFilesByHutools(String inputPath,String outputPath){
      //  FileUtil.copy(inputPath,outputPath,false);
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFilesByRecursive(inputFile,outputFile);
        } catch (IOException e) {
            System.out.println("文件复制失败!");
           e.printStackTrace();
        }
    }

    public static void copyFilesByRecursive(File inputFile,File outPutFile) throws IOException {
        //判断是否是目录
        if (inputFile.isDirectory()){
          //  System.out.println(inputFile.getName());
            File destOutPutFile = new File(outPutFile, inputFile.getName());
            System.out.println(outPutFile);
            System.out.println("-------------------");
            System.out.println(destOutPutFile);

            if (!destOutPutFile.exists()){
                destOutPutFile.mkdirs();
            }
            File[] files = inputFile.listFiles();
            if (ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file : files) {
                copyFilesByRecursive(file,destOutPutFile);
            }
        }
        //如果是文件的话,直接复制到目标目录下
        else {
            Path destPath = outPutFile.toPath();
            Path resolve = destPath.resolve(inputFile.getName());
            System.out.println(destPath);
            System.out.println(resolve);
            System.out.println(inputFile.toPath());
            Files.copy(inputFile.toPath(),resolve, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
