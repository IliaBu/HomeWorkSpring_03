package ru.gb_spring.homeworkspring_03.services;

import ru.gb_spring.homeworkspring_03.domain.User;
import ru.gb_spring.homeworkspring_03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

    /**
     * Функция сортировки списка пользователей по возрасту по возрастанию
     * @param users список пользователей
     * @return отсортированный список пользователей
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Функция фильтрации списка пользователей по возрасту
     * @param users список пользователей
     * @param age возраст
     * @return список пользователей с возрастом больше age
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Функция вычисления среднего возраста пользователей
     * @param users список пользователей
     * @return средний возраст
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
