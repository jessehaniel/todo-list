package tech.ada.java.todolist.todo;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.java.todolist.client.Todo;
import tech.ada.java.todolist.client.TodoRestRepository;
import tech.ada.java.todolist.exceptions.NaoEncontradoException;

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoItemService service;
    private final ModelMapper modelMapper;
    private final TodoRestRepository todoRestRepository;

    @GetMapping
    public List<TodoItemResponse> listarTodos() {
        return this.service.listarTodos().stream()
            .map(this::convertResponse)
            .toList();
    }

    @GetMapping("/{uuid}")
    public TodoItemResponse getPorUuid(@PathVariable UUID uuid) {
        return this.service.getPorUuid(uuid)
            .map(this::convertResponse)
            .orElseThrow(() -> new NaoEncontradoException("TodoItem não encontrado"));
    }

    @GetMapping(params = {"descricao"})
    public List<TodoItemResponse> buscarPorDescricao(@RequestParam String descricao) {
        return this.service.buscarPorDescricao(descricao).stream()
            .map(this::convertResponse)
            .toList();
    }

    private TodoItemResponse convertResponse(TodoItemDto todo) {
        return this.modelMapper.map(todo, TodoItemResponse.class);
    }

    private TodoItemDto convertRequest(TodoItemRequest request) {
        return this.modelMapper.map(request, TodoItemDto.class);
    }

    @PutMapping("{uuid}")
    public TodoItemResponse substituir(@PathVariable UUID uuid, @RequestBody TodoItemRequest request) {
        TodoItemDto updated = this.service.substituir(uuid, this.convertRequest(request));
        return this.convertResponse(updated);
    }

    @PatchMapping("{uuid}/concluir")
    public TodoItemResponse marcarConcluido(@PathVariable UUID uuid) {
        TodoItemDto concluido = this.service.marcarConcluido(uuid);
        return this.convertResponse(concluido);
    }

    @DeleteMapping("{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        this.service.excluir(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponse cadastrar(@RequestBody TodoItemRequest request) {
        TodoItemDto novoItem = this.service.cadastrar(this.convertRequest(request));
        return this.convertResponse(novoItem);
    }

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

}
