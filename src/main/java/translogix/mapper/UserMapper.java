package translogix.mapper;

import translogix.dto.UserRequestDTO;
import translogix.dto.UserResponseDTO;
import translogix.entity.User;

public class UserMapper {

    public static UserResponseDTO toUserResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getEmail()
        );
    }

    public static User toUserRequest(UserRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        User user = new User();
        user.setFirstName(requestDTO.getFirstName());
        user.setSecondName(requestDTO.getSecondName());
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        return user;
    }

}