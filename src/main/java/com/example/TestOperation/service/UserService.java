package com.example.TestOperation.service;

import com.example.TestOperation.model.Admin;
import com.example.TestOperation.model.User;
import com.example.TestOperation.userDAO.AdminRepository;
import com.example.TestOperation.userDAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    public List<User> select() {
        return userRepository.findAll();
    }

    public void insert(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<User> update(Integer id) {
        return userRepository.findById(id);
    }

    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public User userValidation(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    public Admin adminValidation(Admin admin) {
        return adminRepository.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }

    public List<User> salaryGreaterthan(Integer salary) {
        return userRepository.findBySalaryGreaterThan(salary);
    }

    public List<User> salaryLesserthan(Integer salary) {
        return userRepository.findBySalaryLessThan(salary);
    }

    public List<User> salaryEqual(Integer salary) {
        return userRepository.findBySalaryEquals(salary);
    }


    public List<User>filterUser(String operation, User user) {
        if(operation.equals("greater")){
           return salaryGreaterthan(user.getSalary());
        }
        else if(operation.equals("lesser")){
            return salaryLesserthan(user.getSalary());
        }
        else if(operation.equals("equal")){
            return salaryEqual(user.getSalary());
        }
        return null;
    }
}
