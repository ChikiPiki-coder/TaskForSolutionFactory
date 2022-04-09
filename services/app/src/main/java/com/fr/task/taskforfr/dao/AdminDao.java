package com.fr.task.taskforfr.dao;

import com.fr.task.taskforfr.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class AdminDao {

    private final AdminRepository adminRepository;

    public boolean isAdmin(String login, char[] password) {
        return adminRepository.findAdminEntityByLoginAndPassword(login, password) != null;
    }

    public Integer findAdmin(String login, char[] password){
        return adminRepository.findAdminEntityByLoginAndPassword(login, password).getId();
    }

}
