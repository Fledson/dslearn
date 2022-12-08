package com.devsuperior.dslearnbds.repositories;

import com.devsuperior.dslearnbds.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
