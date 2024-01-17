package springbootfirstapp.dao;



import springbootfirstapp.model.User;

import java.util.List;


public interface UserDao {

    List<User> getAllUsers();

    User getUser(Integer id);

    void editUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);

}
