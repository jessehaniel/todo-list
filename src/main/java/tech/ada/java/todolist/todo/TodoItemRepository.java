package tech.ada.java.todolist.todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

    Optional<TodoItem> findByUuid(UUID uuid);
    List<TodoItem> findByDescricaoContainingIgnoreCase(String descricao);

}
