package com.example.demo.service;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    public Page<Expense> findAll(Pageable page) {


        return expenseRepo.findAll(page);
    }


    public Expense save(Expense entity) {


        return expenseRepo.save(entity);


    }

    public Expense getExpenseById(Long id) {
        var result = expenseRepo.findById(id);

        if (result.isPresent()) return result.get();
        throw new ResourceNotFoundException("expense is not found : " + id);
    }

    public void deleteById(long id) {

        Expense entity = getExpenseById(id);


        expenseRepo.deleteById(id);
    }

    public Expense updateExpense(Expense expense, long id) {

        Expense existing = getExpenseById(id);

        existing.setName(expense.getName() != null ? expense.getName() : existing.getName());
        existing.setAmount(expense.getAmount() != 0 ? expense.getAmount() : existing.getAmount());
        existing.setDescription(expense.getDescription() != null ? expense.getDescription() : existing.getDescription());
        return expenseRepo.save(existing);

    }

    public List<Expense> findByCategory(String category, Pageable page) {


        return expenseRepo.findByCategory(category, page).toList();
    }

    public List<Expense> findByNameContaining(String keyword, Pageable page) {

        return expenseRepo.findByNameContaining(keyword, page).toList();

    }

    public List<Expense> findByDateBetween(Date startDate, Date endDate, Pageable page) {
        if (startDate == null)
            startDate = new Date(0);
        if (endDate == null)
            endDate = new Date(System.currentTimeMillis());


        return expenseRepo.findByDateBetween(startDate, endDate, page).toList();

    }
}
