package com.autoparts.AutoParts.dto.make;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MakeRequest {
    @NotEmpty(message = "Enter name")
    @Max(value = 60)
    private String name;
}
