package com.example.demo;


import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ExpenseServiceTest {


    @Autowired
    ExpenseService expRepo;

    @Test
    public void saveExpenseTest() {


        var expEntity = new Expense("asds");

        var result = expRepo.save(expEntity);


        assertTrue(result.getId() > 0);


    }
}
