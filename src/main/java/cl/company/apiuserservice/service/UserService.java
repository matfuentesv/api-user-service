package cl.company.apiuserservice.service;

import cl.company.apiuserservice.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findUser(Long id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
