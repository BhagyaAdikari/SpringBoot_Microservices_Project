package com.project.product_service.service;

import com.project.product_service.model.Expense;
import com.project.product_service.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public void addExpense( Expense expense){
        expenseRepository.insert(expense);
        System.out.println("Service"+expense);
    }

    public void updateExpense(Expense expense){

        Expense savedExpense=expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Expense with id %s not found", expense.getId())
        ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){

        return expenseRepository.findAll();

    }

    public Expense getExpenseByName(String name){
        return expenseRepository.findByName(name).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Expense by Name %s", name)
        ));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
