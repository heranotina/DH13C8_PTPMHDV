package dh13c8.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LoginRequestDTO {
    @NotBlank(message = "Username khong duoc de trong")
    private String username;
    @NotBlank(message = "Password khong duoc de trong")
    private String password;
}