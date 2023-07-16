package com.example.application.data.repository;

import com.example.application.data.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Company entities in the application.
 * Extends the JpaRepository interface to inherit basic CRUD operations for Company entities.
 *
 * @see JpaRepository
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
