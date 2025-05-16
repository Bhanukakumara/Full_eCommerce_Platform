package edu.bks.full_ecommerce_platform.repositories;

import edu.bks.full_ecommerce_platform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
