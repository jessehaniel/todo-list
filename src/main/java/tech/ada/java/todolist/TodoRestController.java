package tech.ada.java.todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-itens")
public class TodoRestController {

    //cadastrar
    //listar todos
    //detalhar por id
    //substituir
    //marcar como concluído
    //excluir

    private final List<TodoItem> todoItemList = new ArrayList<>();

    public TodoRestController() {
        this.todoItemList.addAll(List.of(
            new TodoItem("Tarefa aula 1", "Completar nossa API", LocalDateTime.of(2023, 10, 15, 19, 0)),
            new TodoItem("Ler um livro - técnico", "Ler o livro Código Limpo", LocalDateTime.of(2023, 10, 31, 19, 0)),
            new TodoItem("Ler um livro - cotidiano", "O poder do hábito", LocalDateTime.of(2023, 10, 31, 19, 0)),
            new TodoItem("Ver um filme", "Matrix", LocalDateTime.of(2023, 10, 17, 22, 0)),
            new TodoItem("Ver um filme", "A Origem", LocalDateTime.of(2023, 10, 25, 19, 0)),
            new TodoItem("Finalizar o projeto do projeto", "Nosso projeto de netflix", LocalDateTime.of(2023, 10, 18, 19, 0)),
            new TodoItem("Ir ao café", "Tomar um cafezinho e apreciar a rua", LocalDateTime.of(2023, 10, 18, 9, 0)),
            new TodoItem("Dar uma volta", "Andar pela cidade como um turista", LocalDateTime.of(2023, 10, 19, 10, 0)),
            new TodoItem("Levar o cachorro pra passear", "Viva os doguinhos!", LocalDateTime.of(2023, 10, 16, 10, 0)),
            new TodoItem("Pizza e cerveja", "Completar nossa API", LocalDateTime.of(2023, 10, 18, 19, 0))
        ));
    }

    @GetMapping
    public List<TodoItem> listarTodos() {
        return this.todoItemList;
    }

    @GetMapping("/{id}")//path variable
    public TodoItemResponse getPorId(@PathVariable UUID id) {//GET http://localhost:8080/todo-itens/632e1ccf-6471-447b-af69-5acfce9ba59b
        return this.todoItemList.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst()
            .map(item -> item.toResponse())
            .orElseThrow(() -> new NoSuchElementException("Item não encontrado"));
    }

    @GetMapping(params = {"descricao"})//query parameter
    public List<TodoItemResponse> buscarPorDescricao(@RequestParam String descricao) {//GET http://localhost:8080/todo-itens?descricao=
        return this.todoItemList.stream()
            .filter(item -> item.getDescricao().contains(descricao))
            .map(TodoItem::toResponse)
            .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponse cadastrar(@RequestBody TodoItemRequest request) {
        TodoItem novoItem = new TodoItem(request);
        this.todoItemList.add(novoItem);
        return novoItem.toResponse();
    }

}
