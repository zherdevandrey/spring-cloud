package zherdev.tutorial.photoappusersservice.ui.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlbumsResponseModel {
    private String albumId;
    private String userId;
    private String name;
    private String description;
}
