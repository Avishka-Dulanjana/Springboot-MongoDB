package com.springmongo.springbootmongodbcrud.service;

import com.springmongo.springbootmongodbcrud.entity.Expenses;
import com.springmongo.springbootmongodbcrud.repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {

    private final ExpensesRepository expensesRepository;

    public void addExpenses(Expenses expenses){
        expensesRepository.insert(expenses);
    }
    public void updateExpenses(Expenses expenses){
        Expenses savedExpenses = expensesRepository.findById(expenses.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expenses.getId())));

        savedExpenses.setExpensesName(expenses.getExpensesName());
        savedExpenses.setExpensesCategory(expenses.getExpensesCategory());
        savedExpenses.setExpensesAmount(expenses.getExpensesAmount());

        expensesRepository.save(expenses);
    }
    public List<Expenses> getAllExpenses(){
        return expensesRepository.findAll();
    }
    public Expenses getAllExpensesByName(String name){
        return expensesRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Expense by Name %s", name)));
    }
    public void deleteExpenses(String id){
        expensesRepository.deleteById(id);
    }
}
