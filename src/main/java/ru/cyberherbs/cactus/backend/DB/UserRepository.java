package ru.cyberherbs.cactus.backend.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cyberherbs.cactus.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByEmail(String email);
}
