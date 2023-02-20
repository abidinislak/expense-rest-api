package com.example.demo.service;

import com.example.demo.dataUtils.UserModel;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class UserServiceTest {


    @Autowired
    UserService userService;

    @Test
    public void saveUserTest() {


        User entity = new User();

        entity.setAge(12);
        entity.setEmail("asdas");
        entity.setName("test anakara");


        UserModel model = new UserModel();
        BeanUtils.copyProperties(entity, model);


        var result = userService.save(model);

        assertTrue(result.getId() > 0);

    }

}