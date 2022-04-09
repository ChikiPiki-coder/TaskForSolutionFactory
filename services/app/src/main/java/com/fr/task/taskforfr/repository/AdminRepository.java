package com.fr.task.taskforfr.repository;

import com.fr.task.taskforfr.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {
        AdminEntity findAdminEntityByLoginAndPassword(String login, char[] password);
}
