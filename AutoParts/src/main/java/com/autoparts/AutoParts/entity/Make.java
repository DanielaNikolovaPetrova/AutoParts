package com.autoparts.AutoParts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
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

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Enter name")
    @Max(value = 60)
    private String name;
}
