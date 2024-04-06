package ru.gb_spring.homeworkspring_03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb_spring.homeworkspring_03.domain.User;
import ru.gb_spring.homeworkspring_03.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Список действий над пользователем
     * @return список действий
     */
    @GetMapping()
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Функция сортировки пользователей по ссылке /sort
     *
     * @return отсортированный список пользователей
     */
    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Функция фильтрации пользователей по возрасту по ссылке /filter/{age}
     *
     * @return отфильтрованный список пользователей
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Функция нахождения среднего возраста пользователей по ссылке /calc
     *
     * @return средний возраст пользователей
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }

}
