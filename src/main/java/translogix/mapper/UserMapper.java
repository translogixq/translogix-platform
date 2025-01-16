package translogix.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import translogix.dto.UserRequest;
import translogix.dto.UserResponse;
import translogix.entity.UserEntity;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(UserEntity userEntity);

    UserEntity toEntity(UserRequest userRequest);
}