package com.example.application.data.repository;

import com.example.application.data.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Status entities in the application.
 * Extends the JpaRepository interface to inherit basic CRUD operations for Status entities.
 *
 * @see JpaRepository
 */
public interface StatusRepository extends JpaRepository<Status, Long> {
}
