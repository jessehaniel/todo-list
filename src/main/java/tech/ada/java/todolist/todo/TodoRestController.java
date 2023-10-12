package tech.ada.java.todolist.todo;

import java.util.List;
import java.util.UUID;
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

@RestController
@RequestMapping("/todo-itens")
public class TodoRestController {

    private final TodoItemRepository repository;
    private final ModelMapper modelMapper;
    private final TodoRestRepository todoRestRepository;

    public TodoRestController(TodoItemRepository repository, ModelMapper modelMapper, TodoRestRepository todoRestRepository) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.todoRestRepository = todoRestRepository;
    }

    @GetMapping
    public List<TodoItem> listarTodos() {
        return this.repository.findAll();
    }

    @GetMapping("/{uuid}")
    public TodoItemResponse getPorId(@PathVariable UUID uuid) {
        return this.repository.findByUuid(uuid)
            .map(this::convertResponse)
            .orElseThrow();
    }

    @GetMapping(params = {"descricao"})
    public List<TodoItemResponse> buscarPorDescricao(@RequestParam String descricao) {
        return this.repository.findByDescricaoContainingIgnoreCase(descricao).stream()
            .map(this::convertResponse)
            .toList();
    }

    private TodoItemResponse convertResponse(TodoItem todo) {
        return this.modelMapper.map(todo, TodoItemResponse.class);
    }

    private TodoItem convertRequest(TodoItemRequest request) {
        return this.modelMapper.map(request, TodoItem.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponse cadastrar(@RequestBody TodoItemRequest request) {
        TodoItem todoItem = this.convertRequest(request);
        TodoItem novoItem = this.repository.save(todoItem);
        return this.convertResponse(novoItem);
    }

    @PutMapping("{uuid}")
    public TodoItemResponse substituir(@PathVariable UUID uuid, @RequestBody TodoItemRequest request) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        todoItem.setTitulo(request.getTitulo());
        todoItem.setDescricao(request.getDescricao());
        todoItem.setDataHora(request.getDataHora());
        todoItem.setConcluido(request.getConcluido());
        TodoItem updated = this.repository.save(todoItem);
        return this.convertResponse(updated);
    }

    @PatchMapping("{uuid}/concluir")
    public TodoItemResponse marcarConcluido(@PathVariable UUID uuid) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        todoItem.setConcluido(true);
        TodoItem updated = this.repository.save(todoItem);
        return this.convertResponse(updated);
    }

    @DeleteMapping("{uuid}")
    public void excluir(@PathVariable UUID uuid) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        this.repository.delete(todoItem);
    }

    @PostMapping("/carregar-dummy")
    public Boolean carregarFromDummy() {
        List<Todo> dummyList = this.todoRestRepository.getAll(10L).todos();
        dummyList.forEach(System.out::println);
        return false;
    }

}
