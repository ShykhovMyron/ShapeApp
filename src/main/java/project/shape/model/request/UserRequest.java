package project.shape.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public abstract class UserRequest {
    @NotEmpty(message = "Username must not be empty")
    @Size(min = 4, max = 30, message = "Username size must be between 4 and 30")
    private String username;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 4, max = 30, message = "Password size must be between 4 and 30")
    private String password;
}
