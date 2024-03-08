package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;
@Data
@CommandLine.Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "yupi";

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum = ";
    @Override
    public Integer call() throws Exception {
        MainTemplateConfig templateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this,templateConfig);
        System.out.println("配置信息：" + templateConfig);
        MainGenerator.doGenerate(templateConfig);
        return 0;
    }
}
