package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        final UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Yuliya","Inozemtseva",(byte) 30);
        userService.saveUser("Ivan","Petrov",(byte) 18);
        userService.saveUser("Sergey","Ivanov",(byte) 47);
        userService.saveUser("Irina","Savina",(byte) 22);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
