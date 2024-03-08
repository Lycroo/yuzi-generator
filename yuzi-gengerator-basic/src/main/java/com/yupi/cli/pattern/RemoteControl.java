package com.yupi.cli.pattern;

import lombok.Data;
@Data
public class RemoteControl {
    private Command command;



    public void PressButton(){
        command.execute();;
    }
}
