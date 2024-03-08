package com.yupi.cli.pattern;

public class Client {
    public static void main(String[] args) {
        Device tv = new Device("TV");
        Device stereo = new Device("stereo");
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.PressButton();
        remote.setCommand(turnOff);
        remote.PressButton();

    }
}
