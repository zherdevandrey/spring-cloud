package zherdev.tutorial.photoappusersservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import zherdev.tutorial.photoappusersservice.shared.UserDTO;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);

}
