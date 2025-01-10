package translogix.service;

import translogix.dto.UserRequestDTO;
import translogix.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    User update(String email, UserRequestDTO requestDTO);

    void delete(Long id);
}