package com.example.TestOperation.userDAO;

import com.example.TestOperation.model.Admin;
import com.example.TestOperation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //public List<User> findAll();
    User findByUsernameAndPassword(String username, String password);
    List<User> findBySalaryGreaterThan(Integer salary);
    List<User> findBySalaryLessThan(Integer salary);

    List<User> findBySalaryEquals(Integer salary);

//    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
//    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
//    @Query("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password")
//    Admin findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}

