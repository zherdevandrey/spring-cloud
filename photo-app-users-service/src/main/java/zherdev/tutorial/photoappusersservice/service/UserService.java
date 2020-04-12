package zherdev.tutorial.photoappusersservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import zherdev.tutorial.photoappusersservice.shared.UserDTO;

public interface UserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);

}