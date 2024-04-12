package tech.ada.java.todolist;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoItem {

    private String titulo;
    private String descricao;
    private Boolean concluido;
    private LocalDateTime dataHora;
    private final UUID id;

    public TodoItem() {
        this.id = UUID.randomUUID();
    }

    public TodoItem(String titulo, String descricao, LocalDateTime dataHora) {
        this();
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.concluido = false;
    }

    public TodoItemResponse toResponse() {
        return new TodoItemResponse(this.titulo, this.descricao, this.concluido, this.dataHora, this.id);
    }
}
