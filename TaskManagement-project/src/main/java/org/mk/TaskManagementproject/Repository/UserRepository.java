package org.mk.TaskManagementproject.Repository;

import java.util.Optional;

import org.mk.TaskManagementproject.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);

}
