package com.yupi;

import com.yupi.cli.CommandExecutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      //输入指定个数的数字,算出他们的和
    /*    Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int sum = 0;
            for (int i : arr) {
                sum+=i;
            }
            System.out.println(sum);
        }
        scanner.close();*/
        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);

    }
}