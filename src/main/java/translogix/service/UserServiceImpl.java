package translogix.service;

import org.springframework.stereotype.Service;
import translogix.dto.UserRequestDTO;
import translogix.dto.UserResponseDTO;
import translogix.entity.User;
import translogix.exception.UserNotFoundException;
import translogix.mapper.UserMapper;
import translogix.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO save(UserRequestDTO requestDTO) {
        User user = UserMapper.toUserRequest(requestDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toUserResponse(savedUser);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return UserMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserResponse)
                .toList();
    }

    @Override
    public UserResponseDTO update(String email, UserRequestDTO requestDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        User updatedUser = UserMapper.toUserRequest(requestDTO);
        updatedUser.setId(user.getId());
        User savedUser = userRepository.save(updatedUser);
        return UserMapper.toUserResponse(savedUser);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }

}