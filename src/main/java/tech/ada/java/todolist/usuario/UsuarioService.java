package tech.ada.java.todolist.usuario;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.ada.java.todolist.exceptions.NaoEncontradoException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper modelMapper;


    public List<UsuarioDto> listarTodos() {
        return this.repository.findAll().stream()
            .map(this::convertDto)
            .toList();
    }

    private UsuarioDto convertDto(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDto.class);
    }

    private Usuario convertFromDto(UsuarioDto usuarioDto) {
        return this.modelMapper.map(usuarioDto, Usuario.class);
    }

    public UsuarioDto getByUsername(String username) {
        return this.repository.findByUsername(username)
            .orElseThrow(() -> new NaoEncontradoException("Usuário não encontrado"));
    }

    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
        Usuario usuario = this.convertFromDto(usuarioDto);
        final var save = this.repository.save(usuario);
        return this.convertDto(save);
    }
}
