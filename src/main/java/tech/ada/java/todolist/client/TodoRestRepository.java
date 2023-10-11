package tech.ada.java.todolist.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "todoRest", url = "${dummy.url.todos}")
public interface TodoRestRepository {

    @GetMapping(params = "limit")
    Result getAll(@RequestParam Long limit);

}
