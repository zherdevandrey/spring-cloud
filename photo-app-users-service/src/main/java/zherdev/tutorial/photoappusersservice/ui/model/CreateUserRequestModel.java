package zherdev.tutorial.photoappusersservice.ui.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class CreateUserRequestModel {

    @NotNull(message = "first name cannot be null")
    @Size(min = 1, message = "first name must be > 1 char")
    private String firstName;

    @NotNull(message = "last name cannot be null")
    @Size(min = 1, message = "first name must be > 1 char")
    private String lastName;

    @NotNull(message = "password cannot be null")
    @Size(min = 4, message = "first name must be > 4 char")
    private String password;

    @Email
    @NotNull(message = "email cannot be null")
    private String email;

}
