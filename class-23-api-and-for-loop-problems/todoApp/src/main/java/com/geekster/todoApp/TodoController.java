package com.geekster.todoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //add a list of todos


    @PostMapping("todos")
    public String addTodos(@RequestBody List<Todo> myTodos)
    {
       /* for(Todo todo : myTodos)
        {
            todoList.add(todo);
        }*/

        todoList.addAll(myTodos);

        return myTodos.size() + " todos were added";
    }


    // I want all the tasks which are undone

    @GetMapping("todos/unDone")
    public List<Todo> getAllUndoneTodos()
    {
        //return todoList.stream().filter(todo -> !todo.isTodoStatus()).collect(Collectors.toList());

        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo todo : todoList)
        {
            if(!todo.isTodoStatus())
            {
                unDoneTodos.add(todo);
            }
        }

        return unDoneTodos;

    }


    //delete todos by Ids

    @DeleteMapping("todos/ids")
    public List<Todo> removeTodos(@RequestBody List<Integer> idList)
    {
       /* for(Todo ogtodo : todoList)
        {
            for(Integer id : idList)
            {
                if(ogtodo.getTodoId().equals(id))
                {
                    todoList.remove(ogtodo);
                }
            }
        }*/

       /* for(int i=0;i<todoList.size();i++)
        {
            Todo ogTodo = todoList.get(i);
            for(int j=0;j<idList.size();j++)
            {
                if(ogTodo.getTodoId().equals(idList.get(j)))
                {
                    todoList.remove(ogTodo);
                }
            }
        }*/


        for(Integer id : idList)
        {
            for(int i=0;i<todoList.size();i++)
            {
                if(id.equals(todoList.get(i).getTodoId()))
                {
                    todoList.remove(todoList.get(i));
                    break;
                }
            }
        }

        return todoList;
    }



}
