package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Loan;

public interface EmployeeRepo extends JpaRepository<Loan,Integer> {

}
