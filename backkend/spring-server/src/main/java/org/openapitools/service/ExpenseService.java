package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseInput;
import com.example.expensetracker.model.ExpenseSummary;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense addExpense(ExpenseInput input);

    void deleteExpense(Long id);

    ExpenseSummary getSummary();
}
