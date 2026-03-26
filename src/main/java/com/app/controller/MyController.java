package com.app.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.model.Loan;
import com.app.repo.EmployeeRepo;
@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping("/api/loan")
public class MyController {

    @Autowired
    private EmployeeRepo fRepo;   
    
    // GET ALL
    @GetMapping
    public List<Loan> getAllEmployees() {
        return fRepo.findAll();
    }

    // ADD (POST)
    @PostMapping
    public Loan addEmployee(@RequestBody Loan employee) {
        return fRepo.save(employee);
    }

    // UPDATE (PUT)
    @PutMapping
    public Loan updateEmployee(@RequestParam Integer id, @RequestBody Loan newData) {
        return fRepo.findById(id)
            .map(emp -> {
            emp.setName(newData.getName());
            emp.setEmail(newData.getEmail());
            emp.setPhoneno(newData.getPhoneno());
            emp.setStatus(newData.getStatus());
            emp.setAmount(newData.getAmount());
            emp.setAddress(newData.getAddress());
                return fRepo.save(emp);
            })
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
            }

    // DELETE (DELETE)

    @DeleteMapping
    public String deleteEmployee(@RequestParam Integer id) {
    fRepo.deleteById(id);
    return "Employee Deleted Successfully";
    }
    }

    