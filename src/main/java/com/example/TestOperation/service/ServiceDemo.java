package com.example.TestOperation.service;

import com.example.TestOperation.model.User;
import com.example.TestOperation.userDAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {

    @Autowired
    UserRepository userRepository;

    public User insertService()
    {
        User user=new User();
        //user.setId(1967);
        user.setUsername("QaQ");
        user.setName("vickyDevops");
        user.setEmail("vignesh@gmail.com");
        user.setPassword("12345");
        user.setSalary(10000);
        return userRepository.save(user);
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void scheduledInsert() {
        insertService();
    }
}
