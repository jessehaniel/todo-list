package tech.ada.java.todolist.todo;

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

}
