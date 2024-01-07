package com.senso.mboukhenaif.repository;

import com.senso.mboukhenaif.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
