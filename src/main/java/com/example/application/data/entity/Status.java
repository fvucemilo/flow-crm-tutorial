package com.example.application.data.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents a Status entity in the application.
 * Extends the AbstractEntity class to inherit common properties like ID and version.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Status extends AbstractEntity {

    /**
     * The name of the status.
     */
    private String name;

}

