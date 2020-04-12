package zherdev.tutorial.photoappusersservice.ui.ccontrollers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zherdev.tutorial.photoappusersservice.service.UserService;
import zherdev.tutorial.photoappusersservice.shared.UserDTO;
import zherdev.tutorial.photoappusersservice.ui.model.CreateUserReponseModel;
import zherdev.tutorial.photoappusersservice.ui.model.CreateUserRequestModel;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private Environment environment;
    private UserService userService;

    @GetMapping("/status/check")
    public String status() {
        return "working " + environment.getProperty("local.server.port");
    }

    @GetMapping(value = "/test", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CreateUserRequestModel getUser() {
        return CreateUserRequestModel.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("zherdev@email.com")
                .password("password")
                .build();
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

}
