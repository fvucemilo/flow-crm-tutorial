package com.example.application.data.repository;

import com.example.application.data.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for managing Contact entities in the application.
 * Extends the JpaRepository interface to inherit basic CRUD operations for Contact entities.
 *
 * @see JpaRepository
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    /**
     * Searches for contacts whose first name or last name contains the given search term (case-insensitive).
     *
     * @param searchTerm The search term to look for in contact's first name or last name.
     * @return A list of contacts matching the search criteria.
     */
    @Query(
            """
            SELECT c FROM Contact c
            WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
                OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))
            """
    )
    List<Contact> search(@Param("searchTerm") String searchTerm);

}
