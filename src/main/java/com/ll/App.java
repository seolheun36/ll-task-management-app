package com.ll;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할 일 관리 앱 시작");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("명령) ");
                String cmd = scanner.nextLine().trim();

                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    long id = 1;
                    System.out.print("할 일: ");
                    String content = scanner.nextLine().trim();

                    System.out.printf("%d번 할 일일 생성되었습니다.\n", id);
                }
            }
        }

        System.out.println("할 일 관리 앱 끝");
    }
}
