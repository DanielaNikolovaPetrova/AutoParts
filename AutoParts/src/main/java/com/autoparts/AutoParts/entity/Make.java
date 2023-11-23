package com.autoparts.AutoParts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "makes")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Make {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @NotEmpty(message = "Enter name")
    @Size(min = 2, max = 60)
    private String name;
}
