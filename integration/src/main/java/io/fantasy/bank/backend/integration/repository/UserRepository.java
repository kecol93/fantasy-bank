package io.fantasy.bank.backend.integration.repository;

import io.fantasy.bank.backend.integration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPersonalNumber(String personalNumber);
}
