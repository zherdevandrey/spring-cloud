package zherdev.tutorial.photoappusersservice.ui.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReponseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;
    private List<AlbumsResponseModel> albums;


}
