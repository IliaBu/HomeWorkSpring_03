package ru.gb_spring.homeworkspring_03.services;

import org.springframework.stereotype.Service;
import ru.gb_spring.homeworkspring_03.domain.User;

@Service
public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Функция создания нового пользователя
     *
     * @param name имя
     * @param age возраст
     * @param email почта
     * @return нового пользователя
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);
        return user;
    }
}
