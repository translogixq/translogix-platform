package translogix.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import translogix.dto.UserRequestDTO;
import translogix.dto.UserResponseDTO;
import translogix.entity.User;
import translogix.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        User user = new User();
        user.setFirstName(requestDTO.getFirstName());
        user.setSecondName(requestDTO.getSecondName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());

        User savedUser = userService.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getSecondName(),
                savedUser.getEmail()
        );
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail()
        );
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.findAll().stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getSecondName(),
                        user.getEmail()
                ))
                .toList();
    }

    @PutMapping("/{email}")
    public UserResponseDTO updateUser(@PathVariable String email, @Valid @RequestBody UserRequestDTO requestDTO) {
        User updateUser = userService.update(email, requestDTO);

        return new UserResponseDTO(
                updateUser.getId(),
                updateUser.getFirstName(),
                updateUser.getSecondName(),
                updateUser.getEmail()
        );
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "User with Id " + id + " has been deleted.";
    }

}