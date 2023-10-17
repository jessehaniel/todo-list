package tech.ada.java.todolist.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequest {

    @Email
    private String email;
    @NotBlank
    private String username;
    //TODO -> senha complexa, 10 caracteres, pelo menos 1 maiúscula, 1 minúscula, números, sem caracteres especiais
    //Regex
    private String senha;



}
