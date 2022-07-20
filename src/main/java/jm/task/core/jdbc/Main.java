package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final UserService userService = new UserServiceImpl();


    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();

        userService.saveUser("Джо", "Байден", (byte) 78);
        userService.saveUser("Трамп", "Дональд", (byte) 74);
        userService.saveUser("Барак", "Обама", (byte) 59);
        userService.saveUser("Джордж", "Буш", (byte) 74);



        List<User> userList = userService.getAllUsers();


        userService.removeUserById(userList.get(0).getId());

        userList = userService.getAllUsers();
        for (User s : userList)
            System.out.println(s);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
