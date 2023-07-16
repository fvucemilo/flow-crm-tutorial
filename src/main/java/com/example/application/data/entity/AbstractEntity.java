package com.example.application.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * An abstract base class for entity classes in the application.
 * Provides common properties like the ID and version for all entities.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class AbstractEntity {

    /**
     * The unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgenerator")
    // The initial value is to account for data.sql demo data ids
    @SequenceGenerator(name = "idgenerator", initialValue = 1000)
    private Long id;

    /**
     * The version number for optimistic locking to manage concurrent modifications.
     */
    @Version
    private int version;

}
