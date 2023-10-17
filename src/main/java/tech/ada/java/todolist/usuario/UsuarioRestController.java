package tech.ada.java.todolist.usuario;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final UsuarioService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UsuarioResponse> listarTodos() {
        return this.service.listarTodos().stream()
            .map(this::convertResponse)
            .toList();
    }

    @GetMapping("/{username}")
    public UsuarioResponse getByUsername(@PathVariable String username) {
        UsuarioDto usuarioDto = this.service.getByUsername(username);
        return convertResponse(usuarioDto);
    }

    private UsuarioResponse convertResponse(UsuarioDto usuario) {
        return this.modelMapper.map(usuario, UsuarioResponse.class);
    }

    private UsuarioDto convertRequest(UsuarioRequest usuario) {
        return this.modelMapper.map(usuario, UsuarioDto.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioRequest usuario) {
        UsuarioDto usuarioDto = this.convertRequest(usuario);
        UsuarioDto usuarioSalvo = this.service.cadastrar(usuarioDto);
        return this.convertResponse(usuarioSalvo);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable String username) {
        this.service.desativar(username);
    }

}
