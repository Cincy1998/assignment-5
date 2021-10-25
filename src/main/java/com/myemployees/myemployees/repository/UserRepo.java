package com.myemployees.myemployees.repository;

import com.myemployees.myemployees.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<user,Long> {
}
