package translogix.service;

import translogix.dto.UserRequest;
import translogix.dto.UserResponse;

import java.util.List;

public interface UserService {

    void createUser(UserRequest requestDTO);

    UserResponse findById(Long id);

    List<UserResponse> findAll();

    UserResponse update(String email, UserRequest requestDTO);

    void delete(Long id);
}