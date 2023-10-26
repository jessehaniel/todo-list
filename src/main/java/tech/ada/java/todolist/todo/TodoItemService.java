package tech.ada.java.todolist.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.java.todolist.system.repository.MySpecification;
import tech.ada.java.todolist.system.repository.SearchCriteria;
import tech.ada.java.todolist.usuario.UsuarioService;

@Service
@RequiredArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;
    private final ModelMapper modelMapper;
    private final UsuarioService usuarioService;

    public List<TodoItemDto> listarTodos() {
        return this.repository.findAll().stream()
            .map(this::convertDto)
            .toList();
    }

    private TodoItemDto convertDto(TodoItem todoItem) {
        return this.modelMapper.map(todoItem, TodoItemDto.class);
    }

    private TodoItem convertFromDto(TodoItemDto todoItem) {
        return this.modelMapper.map(todoItem, TodoItem.class);
    }

    public Optional<TodoItemDto> getPorUuid(UUID uuid) {
        return this.repository.findByUuid(uuid).map(this::convertDto);
    }

    public List<TodoItemDto> buscarPorDescricao(String descricao) {
        return this.repository.findByDescricaoContainingIgnoreCase(descricao).stream()
            .map(this::convertDto)
            .toList();
    }

    public TodoItemDto substituir(UUID uuid, TodoItemDto request) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        todoItem.setTitulo(request.getTitulo());
        todoItem.setDescricao(request.getDescricao());
        todoItem.setDataHora(request.getDataHora());
        todoItem.setPrioridade(request.getPrioridade());
        todoItem.setConcluido(request.getConcluido());
        TodoItem updated = this.repository.save(todoItem);
        return this.convertDto(updated);
    }

    public TodoItemDto marcarConcluido(UUID uuid) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        todoItem.setConcluido(true);
        TodoItem updated = this.repository.save(todoItem);
        return this.convertDto(updated);
    }

    public void excluir(UUID uuid) {
        TodoItem todoItem = this.repository.findByUuid(uuid).orElseThrow();
        this.repository.delete(todoItem);
    }

    public TodoItemDto cadastrar(TodoItemDto todoItemDto) {
        TodoItem todoItem = this.convertFromDto(todoItemDto);
        final var usuario = this.usuarioService.getByUsernameEntity(todoItemDto.getUsuario().getUsername());
        todoItem.setUsuario(usuario);
        todoItem.setUuid(UUID.randomUUID());
        final var saved = this.repository.save(todoItem);
        return this.convertDto(saved);
    }

    public TodoItemDto atribuirUsuario(UUID uuid, String username) {
        final var todoItem = this.repository.findByUuid(uuid).orElseThrow();
        final var usuario = this.usuarioService.getByUsernameEntity(username);
        todoItem.setUsuario(usuario);
        final var saved = this.repository.save(todoItem);
        return this.convertDto(saved);
    }

    public List<TodoItemDto> listarMinhasTarefas(String username) {
        return this.repository.findByUsuarioUsername(username).stream()
            .map(this::convertDto)
            .toList();
    }

    public Page<TodoItem> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    public Page<TodoItem> findByExample(TodoItemDto example, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING);
        return this.repository.findAll(Example.of(this.convertFromDto(example), matcher), pageable);
    }

    public Page<TodoItem> findWithSpecs(String query, Pageable pageable) {
        List<SearchCriteria<TodoItem>> params = new ArrayList<>();
        if (query != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(query + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria<>(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        MySpecification<TodoItem> mySpecification = new MySpecification<>(params);
        return this.repository.findAll(mySpecification, pageable);
    }
}
