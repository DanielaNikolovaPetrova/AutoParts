package com.autoparts.AutoParts.dto.partCategory;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PartCategoryRequest {
    @NotEmpty(message = "Enter name")
    @Max(value = 60)
    private String name;

    @Max(value = 220)
    private String description;
}
