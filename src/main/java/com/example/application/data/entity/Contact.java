package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a Contact entity in the application.
 *
 * @see AbstractEntity
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Contact extends AbstractEntity {

    /**
     * The first name of the contact. It must not be empty.
     */
    @NotEmpty
    private String firstName = "";

    /**
     * The last name of the contact. It must not be empty.
     */
    @NotEmpty
    private String lastName = "";

    /**
     * The company associated with the contact.
     * It is mapped to the "company_id" column in the database.
     * It must not be null.
     * The "employees" property of the associated company is ignored during JSON serialization.
     */
    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotNull
    @JsonIgnoreProperties({"employees"})
    private Company company;

    /**
     * The status of the contact.
     * It must not be null.
     */
    @NotNull
    @ManyToOne
    private Status status;

    /**
     * The email address of the contact. It must be a valid email format and not empty.
     */
    @Email
    @NotEmpty
    private String email = "";

    /**
     * Returns a string representation of the contact, using the first name and last name.
     *
     * @return A string containing the first name and last name of the contact.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
