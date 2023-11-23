package com.autoparts.AutoParts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "parts")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Part {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Enter name")
    @Size(min = 2, max = 60)
    private String name;

    @Column(name = "description")
    @Size(max = 220)
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Part should have a price")
    private Long price;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_categories")
    private PartCategory partCategory;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "part_model_mapping",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    private Set<Model> models;
}
