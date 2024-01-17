package springbootfirstapp.service;


import springbootfirstapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(Integer id);

    void editUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

}
