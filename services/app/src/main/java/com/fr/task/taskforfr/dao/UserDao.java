package com.fr.task.taskforfr.dao;

import com.fr.task.taskforfr.entity.UserEntity;
import com.fr.task.taskforfr.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Data
@AllArgsConstructor
public class UserDao {
    private final UserRepository userRepository;

    public String save(UserEntity userEntity){
        UUID uniqueKey = UUID.randomUUID();
        String identifier =uniqueKey.toString();
        userEntity.setIdentifier(identifier);
        userRepository.save(userEntity);
        return  identifier;
    }
}
