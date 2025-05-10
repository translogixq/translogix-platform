package translogix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import translogix.dto.UserRequest;
import translogix.dto.UserResponse;
import translogix.entity.UserEntity;
import translogix.exception.UserNotFoundException;
import translogix.mapper.UserMapper;
import translogix.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserRequest requestDTO) {
        UserEntity userEntity = userMapper.toEntity(requestDTO);
        userRepository.save(userEntity);
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new UserNotFoundException("UserEntity not found with ID: " + id));
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse update(String email, UserRequest requestDTO) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("UserEntity not found with email: " + email));
        UserEntity updatedUserEntity = userMapper.toEntity(requestDTO);
        updatedUserEntity.setId(userEntity.getId());
        UserEntity savedUserEntity = userRepository.save(updatedUserEntity);
        return userMapper.toResponse(savedUserEntity);
    }

    @Override
    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("UserEntity not found with id: " + id));
        userRepository.delete(userEntity);
    }

}