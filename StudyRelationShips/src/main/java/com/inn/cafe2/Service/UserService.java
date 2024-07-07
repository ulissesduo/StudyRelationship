package com.inn.cafe2.Service;

import com.inn.cafe2.DTO.Request.UserRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserRequest userReq) throws Exception{
        User user = this.getUserById(id);
        if(user == null){
            throw new Exception("Couldn't find the user with the id " + id);
        }
        user.setName(userReq.getName());
        user.setLastName(userReq.getLastName());
        user.setEmail(userReq.getEmail());
        user.setLogin(userReq.getLogin());
        user.setPassword(userReq.getPassword());
        user.setAge(userReq.getAge());
        user.setGender(userReq.getGender());

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        User user = userRepository.findById(id).orElse(null);
        if(user == null){
            throw new Exception("Couldn't find the user");
        }
        userRepository.deleteById(id);
    }
}
