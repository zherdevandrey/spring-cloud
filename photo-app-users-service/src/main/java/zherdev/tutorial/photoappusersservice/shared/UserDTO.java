package zherdev.tutorial.photoappusersservice.shared;

import lombok.*;
import zherdev.tutorial.photoappusersservice.ui.model.AlbumsResponseModel;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String userId;
    private String encryptedPassword;
    List<AlbumsResponseModel> albumList;
}
