package com.example.expensetracker.api;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseInput;
import com.example.expensetracker.model.ExpenseSummary;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensesApiController implements ExpensesApi {

    private final ExpenseService service;

    public ExpensesApiController(ExpenseService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @Override
    public ResponseEntity<Expense> addExpense(ExpenseInput input) {
        return ResponseEntity.ok(service.addExpense(input));
    }

    @Override
    public ResponseEntity<Void> deleteExpense(Long id) {
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ExpenseSummary> getSummary() {
        return ResponseEntity.ok(service.getSummary());
    }
}
