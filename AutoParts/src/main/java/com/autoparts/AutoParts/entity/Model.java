package com.autoparts.AutoParts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "models")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Enter name")
    @Size(min = 2, max = 60)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "makes")
    private Make make;

    @JsonIgnore
    @ManyToMany(mappedBy = "models")
    private List<Part> parts;
}
