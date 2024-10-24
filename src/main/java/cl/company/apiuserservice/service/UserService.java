package cl.company.apiuserservice.service;

import cl.company.apiuserservice.exception.ApiResponse;
import cl.company.apiuserservice.model.Users;

import java.util.List;

public interface UserService {

    ApiResponse login(String userName,String password);
    List<Users> findAll();
    Users findUser(Long id);
    Users createUser(Users users);
    Users updateUser(Users users);
    void deleteUser(Long id);
}
