package com.springmongo.springbootmongodbcrud.controller;

import com.springmongo.springbootmongodbcrud.entity.Expenses;
import com.springmongo.springbootmongodbcrud.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/expenses"})
@CrossOrigin
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    @PostMapping
    public ResponseEntity addExpenses(@RequestBody Expenses expenses){
        expenseService.addExpenses(expenses);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity updateExpenses(@RequestBody Expenses expenses){
        expenseService.updateExpenses(expenses);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @GetMapping({"/{name}"})
    public ResponseEntity<Expenses> getAllExpensesByName(@PathVariable String name ){
        return ResponseEntity.ok(expenseService.getAllExpensesByName(name));
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity deleteExpenses(@PathVariable String id){
        expenseService.deleteExpenses(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
