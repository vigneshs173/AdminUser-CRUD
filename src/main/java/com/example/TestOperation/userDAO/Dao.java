package com.example.TestOperation.userDAO;
import com.example.TestOperation.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Dao {

    private final JdbcTemplate jdbcTemplate;

    public Dao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getData() {
        String qry = "SELECT * FROM USER";
        return jdbcTemplate.query(qry, new BeanPropertyRowMapper<>(User.class));
    }
}
