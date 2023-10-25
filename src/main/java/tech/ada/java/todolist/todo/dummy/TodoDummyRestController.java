package tech.ada.java.todolist.todo.dummy;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolist.client.Todo;
import tech.ada.java.todolist.client.TodoRestRepository;
import tech.ada.java.todolist.todo.TodoItemDto;
import tech.ada.java.todolist.todo.TodoItemResponse;
import tech.ada.java.todolist.todo.TodoItemService;

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoDummyRestController {

    private final TodoItemService service;
    private final TodoRestRepository todoRestRepository;
    private final ModelMapper modelMapper;
    @PostMapping("/carregar-dummy")
    public Boolean carregarFromDummy() {
        List<Todo> dummyList = this.todoRestRepository.getAll(10L).todos();
        dummyList.stream()
            .map(this::converterTodoEmTodoItem)
            .forEach(this.service::cadastrar);
        return true;
    }

    private TodoItemDto converterTodoEmTodoItem(Todo todo) {
        TodoItemDto todoItem = new TodoItemDto();
        todoItem.setConcluido(todo.completed());
        todoItem.setTitulo(todo.todo());
        todoItem.setDescricao(todo.todo());
        return todoItem;
    }

    @PatchMapping("/{uuid}/atribuir-usuario/{username}")
    public TodoItemResponse atribuirUsuario(@PathVariable UUID uuid, @PathVariable String username) {
        TodoItemDto todoItemDto = this.service.atribuirUsuario(uuid, username);
        return this.modelMapper.map(todoItemDto, TodoItemResponse.class);
    }
}
