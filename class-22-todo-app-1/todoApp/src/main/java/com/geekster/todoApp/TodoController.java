package com.geekster.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    List<Todo> todoList;

    //create todos -Post APIs

    //add a todo

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo myTodo)
    {
        todoList.add(myTodo);
        return "todo added";
    }



    // get api

    //get all todos:

    @GetMapping("todos")
    public List<Todo> getAllTodos()
    {
        return  todoList;
    }


    //update todo :

    // send a todo id :id1 and status:s1

    @PutMapping("todo/id/{id}/status")
    public String setTodoStatusById(@PathVariable Integer id,@RequestParam boolean flag)
    {
        for(Todo todo : todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todo.setTodoStatus(flag);
                return "todo: "   + id  + "updated to " +  flag;
            }
        }

        return "Invalid id";
    }


    //delete api

    @DeleteMapping("todo/id/{id}")
    public String removeTodoById(@PathVariable Integer id)
    {
        for(Todo todo : todoList)
        {
            if(todo.getTodoId().equals(id))
            {
                todoList.remove(todo);
                return "todo: "   + id  + " removed";
            }
        }

        return "Invalid id";
    }


    //get all done todos
    //add a list of todos
}
