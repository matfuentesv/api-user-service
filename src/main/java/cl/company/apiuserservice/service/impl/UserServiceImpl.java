package cl.company.apiuserservice.service.impl;

import cl.company.apiuserservice.model.Users;
import cl.company.apiuserservice.repository.UserRepository;
import cl.company.apiuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        } else {
            return new Users();
        }
    }

    @Override
    public Users createUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users updateUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
