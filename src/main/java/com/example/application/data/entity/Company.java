package com.example.application.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Formula;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Company entity in the application.
 *
 * @see AbstractEntity
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Company extends AbstractEntity {

    /**
     * The name of the company. It must not be blank.
     */
    @NotBlank
    private String name;

    /**
     * The list of employees associated with the company.
     * It is mapped by the "company" field in the Contact entity.
     * Can be null, but typically initialized to an empty list.
     */
    @OneToMany(mappedBy = "company")
    @Nullable
    private List<Contact> employees = new LinkedList<>();

    /**
     * The employee count of the company calculated using a custom SQL formula.
     * The formula executes a sub-query to count the number of contacts associated with this company.
     */
    @Formula("(select count(c.id) from Contact c where c.company_id = id)")
    private int employeeCount;

}
