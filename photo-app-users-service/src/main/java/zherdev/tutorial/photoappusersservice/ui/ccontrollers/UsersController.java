package zherdev.tutorial.photoappusersservice.ui.ccontrollers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import zherdev.tutorial.photoappusersservice.data.AlbumServiceClient;
import zherdev.tutorial.photoappusersservice.service.UserService;
import zherdev.tutorial.photoappusersservice.shared.UserDTO;
import zherdev.tutorial.photoappusersservice.ui.model.AlbumsResponseModel;
import zherdev.tutorial.photoappusersservice.ui.model.CreateUserReponseModel;
import zherdev.tutorial.photoappusersservice.ui.model.CreateUserRequestModel;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private Environment environment;
    private UserService userService;
    //private RestTemplate restTemplate;
    private AlbumServiceClient albumServiceClient;

    @GetMapping("/status/check")
    public String status() {
        return "working " + environment.getProperty("local.server.port");
    }

    @GetMapping(value = "/test", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String test() {
        return environment.getProperty("test.property");
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<CreateUserReponseModel> createUser(@Valid @RequestBody CreateUserRequestModel createUserModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(createUserModel, UserDTO.class);
        UserDTO createdUser = userService.createUser(userDTO);
        CreateUserReponseModel createUserReponseModel = modelMapper.map(createdUser, CreateUserReponseModel.class);
        return new ResponseEntity(createUserReponseModel, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable("userId") String userId){
        UserDTO userDTO = userService.getByUserId(userId);
        List<AlbumsResponseModel> albumList = albumServiceClient.userAlbums(userId);
        userDTO.setAlbumList(albumList);
        return userDTO;
    }

}
