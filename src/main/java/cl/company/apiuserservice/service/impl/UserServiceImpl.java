package cl.company.apiuserservice.service.impl;

import cl.company.apiuserservice.model.User;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        } else {
            return new User();
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
