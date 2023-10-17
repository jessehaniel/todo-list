package tech.ada.java.todolist.usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //projection
    @Query("""
    select new tech.ada.java.todolist.usuario.UsuarioDto(u.email, u.username, u.senha)
     from Usuario u where u.username = :username
    """)
    Optional<UsuarioDto> findByUsername(@Param("username") String username);

}
