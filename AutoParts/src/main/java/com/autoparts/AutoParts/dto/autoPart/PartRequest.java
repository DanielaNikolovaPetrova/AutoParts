package com.autoparts.AutoParts.dto.autoPart;

import com.autoparts.AutoParts.entity.autoPart.Model;
import com.autoparts.AutoParts.entity.autoPart.PartCategory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PartRequest {
    @NotEmpty
    @Max(value = 60)
    private String name;

    @Max(value = 220)
    private String description;

    @NotNull
    private Long price;

    @NotNull
    private PartCategory partCategory;
    private Set<Model> models;
}
