package com.example.demo.service;

import com.example.demo.dataUtils.UserModel;
import com.example.demo.exception.ItemAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRep;

    public User save(UserModel userModel) {

        if (userRep.existsByEmail(userModel.getEmail())) {


            throw new ItemAlreadyExistsException("USer is alredy " + userModel.getEmail());
        }

        User entity = new User();
        BeanUtils.copyProperties(userModel, entity);

        return userRep.save(entity);
    }

    public User findById(long id) {

        return userRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("user can not found with id" + id));
    }

    public User update(Long id, UserModel model) {
        User entity = findById(id);
        entity.setName(model.getName() != null ? model.getName() : entity.getName());
        entity.setAge(model.getAge() > 0 ? model.getAge() : entity.getAge());

        entity.setEmail(model.getEmail() != null ? model.getEmail() : entity.getEmail());

        return userRep.save(entity);
    }

    public void delete(Long id) {
        User entity = findById(id);
        userRep.delete(entity);

    }
}
