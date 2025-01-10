package translogix.service;

import org.springframework.stereotype.Service;
import translogix.dto.UserRequestDTO;
import translogix.entity.User;
import translogix.exception.UserNotFoundException;
import translogix.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(String email, UserRequestDTO requestDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        user.setFirstName(requestDTO.getFirstName());
        user.setSecondName(requestDTO.getSecondName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        userRepository.delete(user);
    }

}