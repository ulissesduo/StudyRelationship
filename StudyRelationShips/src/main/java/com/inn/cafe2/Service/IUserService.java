package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User updateUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteById(Long id) throws Exception;
}
