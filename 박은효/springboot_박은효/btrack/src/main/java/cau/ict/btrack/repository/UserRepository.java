package cau.ict.btrack.repository;

import cau.ict.btrack.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
