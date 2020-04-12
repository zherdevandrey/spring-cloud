package zherdev.tutorial.photoappusersservice.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zherdev.tutorial.photoappusersservice.data.UserEntity;
import zherdev.tutorial.photoappusersservice.data.UserRepository;
import zherdev.tutorial.photoappusersservice.shared.UserDTO;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        userDTO.setUserId(UUID.randomUUID().toString());
        userDTO.setEncryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserDTO savedUserDTO = modelMapper.map(savedUserEntity, UserDTO.class);
        return savedUserDTO;
    }
}