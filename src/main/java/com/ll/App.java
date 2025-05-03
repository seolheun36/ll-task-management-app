package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할 일 관리 앱 시작");

        try (Scanner scanner = new Scanner(System.in)) {
            List<Todo> todos = new ArrayList<>();
            long todosLastID = 0;

            while (true) {
                System.out.print("명령) ");
                String cmd = scanner.nextLine().trim();

                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    long id = todosLastID + 1;
                    System.out.print("할 일: ");
                    String content = scanner.nextLine().trim();

                    Todo todo = new Todo(id, content);
                    todos.add(todo);
                    todosLastID++;

                    System.out.printf("%d번 할 일일 생성되었습니다.\n", id);
                } else if (cmd.equals("list")) {
                    System.out.println("번호 / 내용");

                    todos.forEach(todo -> System.out.printf("%d / %s\n", todo.getId(), todo.getContent()));
                } else if (cmd.equals("del")) {
                    System.out.print("삭제할 할 일의 번호: ");
                    long id = Long.parseLong(scanner.nextLine().trim());

                    boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

                    if (!isRemoved) {
                        System.out.printf("%d번 할 일은 존재하지 않습니다.\n", id);
                        continue;
                    }

                    System.out.printf("%d번 할 일이 삭제되었습니다.\n", id);
                } else if (cmd.equals("modify")) {
                    System.out.print("수정할 할 일의 번호: ");
                    long id = Long.parseLong(scanner.nextLine().trim());

                    Todo foundTodo = todos.stream()
                            .filter(t -> t.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (foundTodo == null) {
                        System.out.printf("%d번 할 일은 존재하지 않습니다.\n", id);
                        continue;
                    }

                    System.out.printf("기존 할 일: %s\n", foundTodo.getContent());
                    System.out.print("새 할 일: ");
                    foundTodo.setContent(scanner.nextLine().trim());

                    System.out.printf("%d번 할 일이 수정되었습니다.\n", id);
                }
            }
        }

        System.out.println("할 일 관리 앱 끝");
    }
}
