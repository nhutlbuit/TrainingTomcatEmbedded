package com.training.controller;

import com.training.model.Todo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/test/error/handler")
public class RestApiController {

    private List<Todo> todoList;

    @PostConstruct
    public void init() {
        todoList = IntStream.range(0, 10)
                .mapToObj(i -> new Todo("title-" + i, "detail-" + i))
                .collect(Collectors.toList());
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) throws Exception {
       // NullPointerException
        todoList = null;
        todoList.get(0);
        // IndexOutOfBoundsException
        Todo todo = todoList.get(todoId);
        return todo;
    }

    public void optionalJava8() {
       // callOptionalVariable("Le", "Nam", 22);
    }

    private String callOptionalVariable(String firstName, Optional<String> lastName, Optional<Integer> age) {
        return firstName + ' ' + lastName + ' ' + String.valueOf(age);
    }
}