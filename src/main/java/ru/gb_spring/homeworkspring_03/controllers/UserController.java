package ru.gb_spring.homeworkspring_03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb_spring.homeworkspring_03.domain.User;
import ru.gb_spring.homeworkspring_03.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Функция добавления пользователя из тела запроса
     *
     * @param user сформированный пользователь
     * @return сообщение на запрос
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.processRegistration(user);
        return "Пользователь добавлен!";
    }

    /**
     * Функция добавления пользователя из параметров запроса
     *
     * @param name имя пользователя
     * @param age возраст
     * @param email эл.почта
     * @return сообщение на запрос
     */
    @PostMapping("/param")
    public String userAddFromParam(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("email") String email) {
        service.processRegistration(name, age, email);
        return "Пользователь добавлен из параметра http";
    }
}
