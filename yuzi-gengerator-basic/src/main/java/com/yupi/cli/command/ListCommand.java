package com.yupi.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)

public class ListCommand implements Runnable{
    @Override
    public void run() {
        String property = System.getProperty("user.dir");
        String parent = new File(property).getParent();
        System.out.println(parent);
        String absolutePath = new File(parent, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(absolutePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
