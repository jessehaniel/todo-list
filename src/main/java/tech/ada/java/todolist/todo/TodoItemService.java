package tech.ada.java.todolist.todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoItemService {

    private final TodoItemRepository repository;
    private final ModelMapper modelMapper;

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
        final var saved = this.repository.save(todoItem);
        return this.convertDto(saved);
    }
}
