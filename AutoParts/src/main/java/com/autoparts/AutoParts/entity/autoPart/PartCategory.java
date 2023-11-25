package com.autoparts.AutoParts.entity.autoPart;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Table(name = "part_categories")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Enter name")
    @Max(value = 60)
    private String name;

    @Column(name = "description")
    @Max(value = 220)
    private String description;
}
