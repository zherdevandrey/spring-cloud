package zherdev.tutorial.photoappusersservice.ui.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestModel {

    private String email;
    private String password;

}
