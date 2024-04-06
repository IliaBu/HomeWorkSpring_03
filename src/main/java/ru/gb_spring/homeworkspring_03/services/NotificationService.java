package ru.gb_spring.homeworkspring_03.services;

import org.springframework.stereotype.Service;
import ru.gb_spring.homeworkspring_03.domain.User;

@Service
public class NotificationService {

    /**
     * Функция вывода сообщения в консоль об успешном создании нового пользователя
     * @param user пользователь
     */
    public void notifyUser(User user) {
        System.out.println(Colors.YELLOW + "Создан новый пользователь: " + user.getName() + Colors.RESET);
    }

    /**
     * Функция вывода сообщения в консоль об успешном добавлении нового пользователя в базу данных
     * @param user пользователь
     */
    public void addUserToRepository(User user){
        System.out.println(Colors.YELLOW + "Пользователь: " + user.getName() + " добавлен в базу данных" + Colors.RESET);
    }
}
