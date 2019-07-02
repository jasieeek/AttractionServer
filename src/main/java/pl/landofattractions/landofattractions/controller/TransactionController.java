package pl.landofattractions.landofattractions.controller;

import org.springframework.web.bind.annotation.*;
import pl.landofattractions.landofattractions.model.Transaction;
import pl.landofattractions.landofattractions.repository.TransactionRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/transactions")
    public List<Transaction> getUsers() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @PostMapping("/transactions")
    void addUser(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
