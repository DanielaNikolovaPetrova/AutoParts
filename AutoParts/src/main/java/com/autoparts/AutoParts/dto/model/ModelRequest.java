package com.autoparts.AutoParts.dto.model;

import com.autoparts.AutoParts.entity.Make;
import com.autoparts.AutoParts.entity.Part;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ModelRequest {
    @NotEmpty(message = "Enter name")
    @Max(value = 60)
    private String name;

    @NotNull
    private Make make;

    private List<Part> parts;
}
