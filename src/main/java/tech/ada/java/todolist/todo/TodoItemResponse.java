package tech.ada.java.todolist.todo;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoItemResponse(String titulo, String descricao, Boolean concluido, LocalDateTime dataHora, UUID uuid, PrioridadeEnum prioridade) { }
