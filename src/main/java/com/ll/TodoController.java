package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoController {
    private final Scanner scanner;
    private final ArrayList<Todo> todos;
    private long todosLastId;

    public TodoController() {
        scanner = new Scanner(System.in);
        todos = new ArrayList<>();
        todosLastId = 0;
    }

    public void modify() {
        System.out.print("수정할 할 일의 번호: ");
        long id = Long.parseLong(scanner.nextLine().trim());

        Todo foundTodo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (foundTodo == null) {
            System.out.printf("%d번 할 일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 할 일: %s\n", foundTodo.getContent());
        System.out.print("새 할 일: ");
        foundTodo.setContent(scanner.nextLine().trim());

        System.out.printf("%d번 할 일이 수정되었습니다.\n", id);
    }

    public void del() {
        System.out.print("삭제할 할 일의 번호: ");
        long id = Long.parseLong(scanner.nextLine().trim());

        boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

        if (!isRemoved) {
            System.out.printf("%d번 할 일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("%d번 할 일이 삭제되었습니다.\n", id);
    }

    public void list() {
        System.out.println("번호 / 내용");

        todos.forEach(todo -> System.out.printf("%d / %s\n", todo.getId(), todo.getContent()));
    }

    public void add() {
        long id = todosLastId + 1;
        System.out.print("할 일: ");
        String content = scanner.nextLine().trim();

        Todo todo = new Todo(id, content);
        todos.add(todo);
        todosLastId++;

        System.out.printf("%d번 할 일일 생성되었습니다.\n", id);
    }
}
