package zherdev.tutorial.photoappusersservice.ui.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReponseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;

}
