package com.autoparts.AutoParts.dto.user;
import com.autoparts.AutoParts.entity.user.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {
    @NotBlank
    @Length(min=3, message = "Username should contain at least 3 characters")
    private String username;

    @NotBlank
    @Length(min = 8, message = "Password should contains at least 8 characters")
    private String password;

    private UserRole userRole;
}
