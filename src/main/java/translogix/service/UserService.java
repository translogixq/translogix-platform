package translogix.service;

import translogix.dto.UserRequestDTO;
import translogix.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO save(UserRequestDTO requestDTO);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO update(String email, UserRequestDTO requestDTO);

    void delete(Long id);
}