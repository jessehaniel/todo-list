package tech.ada.java.todolist.todo;

import java.security.Principal;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
import tech.ada.java.todolist.exceptions.NaoEncontradoException;
import tech.ada.java.todolist.usuario.UsuarioDto;

@RestController
@RequestMapping("/todo-itens")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoItemService service;
    private final TodoItemRepository repository;
    private final ModelMapper modelMapper;

    @GetMapping
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Role).ADMIN.name())")
    public List<TodoItemResponse> listarTodos() {
        return this.service.listarTodos().stream()
            .map(this::convertResponse)
            .toList();
    }

    @GetMapping("/minhas-tarefas")
    public List<TodoItemResponse> listarMinhasTarefas(Principal principal) {
        return this.service.listarMinhasTarefas(principal.getName()).stream()
            .map(this::convertResponse)
            .toList();
    }

    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Role).CLIENTE.name())")
    public TodoItemResponse getPorUuid(@PathVariable UUID uuid) {
        return this.service.getPorUuid(uuid)
            .map(this::convertResponse)
            .orElseThrow(() -> new NaoEncontradoException("TodoItem não encontrado"));
    }

    @GetMapping(params = {"descricao"})
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Role).CLIENTE.name())")
    public List<TodoItemResponse> buscarPorDescricao(@RequestParam String descricao) {
        return this.service.buscarPorDescricao(descricao).stream()
            .map(this::convertResponse)
            .toList();
    }

    @GetMapping(value = "/complexo", params = { "query" })//todo-itens?query=dataHora>2023-10-25ANDconcluido:true
    public Page<TodoItem> complexo(@RequestBody TodoItemRequest example, @RequestParam String query, Pageable pageable) {
        if (example != null) {
            return this.service.findByExample(this.convertRequest(example), pageable);
        } else if (query != null) {
            return this.service.findWithSpecs(query, pageable);
        }
        return this.service.findAll(pageable);
    }

    private TodoItemResponse convertResponse(TodoItemDto todo) {
        return this.modelMapper.map(todo, TodoItemResponse.class);
    }

    private TodoItemDto convertRequest(TodoItemRequest request) {
        return this.modelMapper.map(request, TodoItemDto.class);
    }

    @PutMapping("{uuid}")
    @PreAuthorize("hasRole(T(tech.ada.java.todolist.usuario.Role).CLIENTE.name())")
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
        final var todoItemDto = this.convertRequest(request);
        todoItemDto.setUsuario(new UsuarioDto(request.getUsername()));
        TodoItemDto novoItem = this.service.cadastrar(todoItemDto);
        return this.convertResponse(novoItem);
    }


}
