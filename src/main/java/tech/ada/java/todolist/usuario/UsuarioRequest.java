package tech.ada.java.todolist.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioRequest {

    @Email
    private String email;
    @Pattern(regexp = "[\\w.]{5,20}", message = "Username deve ser alfanumérico entre 5 e 20 caracteres (lowercase, uppercase, numbers, _, .)")
    private String username;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
        message = "A senha deve conter de 8 a 20 caracteres (lowercase, uppercase, numbers, special, no-sequences)")
    private String password;



}
