package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {


    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
      //  File parentFile = new File(projectPath).getParentFile();
        System.out.println("parentFile的抽象路径名:"+projectPath);
        String inputPath = new File(projectPath, "yuzi-generator-demo-projects" + File.separatorChar + "acm-template").getAbsolutePath();
        String outputPath = projectPath;
        StaticGenerator.CopyFilesByHutools(inputPath,outputPath);
        String inputDynamicFilePath = projectPath + File.separatorChar+ "yuzi-gengerator-basic"+ File.separatorChar + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separatorChar + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yuchen");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("xxx：");
        doGenerate(mainTemplateConfig);
    }
}
