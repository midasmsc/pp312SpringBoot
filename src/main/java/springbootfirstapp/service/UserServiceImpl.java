package springbootfirstapp.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import springbootfirstapp.dao.UserDao;
import springbootfirstapp.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void editUser(Integer id) {
        userDao.editUser(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);

    }
}


