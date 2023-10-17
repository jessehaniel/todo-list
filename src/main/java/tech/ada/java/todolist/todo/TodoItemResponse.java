package tech.ada.java.todolist.todo;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.ada.java.todolist.usuario.UsuarioResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class TodoItemResponse {

    private UUID uuid;
    private String titulo;
    private String descricao;
    private Boolean concluido;
    private LocalDateTime dataHora;
    private PrioridadeEnum prioridade;
    private UsuarioResponse usuario;

}
