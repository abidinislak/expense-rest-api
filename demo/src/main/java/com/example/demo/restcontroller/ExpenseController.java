package com.example.demo.restcontroller;


import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ExpenseController {


    @Autowired
    private ExpenseService expenseService;


    @GetMapping("/expenses")

    public List<Expense> getAllExpenses(Pageable page) {


//        var rsult = 1 / 0;


        return expenseService.findAll(page).toList();
    }


    @GetMapping("/expense/{id}")

    public Expense getExpenseById(@PathVariable Long id) {


        return expenseService.getExpenseById(id);

    }


    @GetMapping("/expense")

    public String getExpenseByIdMultiple(@RequestParam long id, @RequestParam long entityid) {


        return "expense id queried is :" + id + " and " + entityid;

    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("expense")
    public void deleteByid(@RequestParam long id) {
        expenseService.deleteById(id);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/expenses")
    private Expense saveExpense(@Valid @RequestBody Expense expense) {


        return expenseService.save(expense);
    }


    @PutMapping("/expenses/{id}")
    private Expense updateExpense(@RequestBody Expense expense, @PathVariable long id) {
        return expenseService.updateExpense(expense, id);


    }


    @GetMapping("expenses/category")
    public List<Expense> findByCategory(@RequestParam String category, Pageable page) {

        return expenseService.findByCategory(category, page);


    }


    @GetMapping("/expenses/name")
    public List<Expense> findByNameContaining(@RequestParam String keyword, Pageable page) {

        return expenseService.findByNameContaining(keyword, page);


    }


    @GetMapping("/expenses/date")
    public List<Expense> findByDateBetween(@RequestParam(required = false) Date startDate, Date endDate, Pageable page) {

        return expenseService.findByDateBetween(startDate, endDate, page);

    }


}
