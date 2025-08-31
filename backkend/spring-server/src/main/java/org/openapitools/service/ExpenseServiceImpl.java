package com.example.expensetracker.service;

import com.example.expensetracker.entity.ExpenseEntity;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.model.ExpenseInput;
import com.example.expensetracker.model.ExpenseSummary;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll().stream().map(this::mapToModel).collect(Collectors.toList());
    }

    @Override
    public Expense addExpense(ExpenseInput input) {
        ExpenseEntity entity = new ExpenseEntity();
        entity.setDescription(input.getDescription());
        entity.setAmount(input.getAmount());
        entity.setDate(input.getDate());
        entity.setCategory(input.getCategory());
        ExpenseEntity saved = repository.save(entity);
        return mapToModel(saved);
    }

    @Override
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ExpenseSummary getSummary() {
        List<ExpenseEntity> all = repository.findAll();
        double total = all.stream().mapToDouble(ExpenseEntity::getAmount).sum();

        ExpenseSummary summary = new ExpenseSummary();
        summary.setTotalAmount(total);
        summary.setTotalCount(all.size());
        return summary;
    }

    private Expense mapToModel(ExpenseEntity entity) {
        Expense expense = new Expense();
        expense.setId(entity.getId());
        expense.setDescription(entity.getDescription());
        expense.setAmount(entity.getAmount());
        expense.setDate(entity.getDate());
        expense.setCategory(entity.getCategory());
        return expense;
    }
}
