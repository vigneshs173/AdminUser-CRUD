package com.example.TestOperation.userDAO;

import com.example.TestOperation.model.Admin;
import com.example.TestOperation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUsernameAndPassword(String username,String password);

}
