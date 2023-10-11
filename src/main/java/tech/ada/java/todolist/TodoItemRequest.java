package tech.ada.java.todolist;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoItemRequest {

    private String titulo;
    private String descricao;
    private Boolean concluido;
    private LocalDateTime dataHora;

    public TodoItemRequest(String titulo, String descricao, Boolean concluido, LocalDateTime dataHora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
        this.dataHora = dataHora;
    }
}
