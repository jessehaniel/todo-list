package tech.ada.java.todolist.client;

import java.util.List;

public record Result(List<Todo> todos, Long total, Long skip, Long limit) {

}
