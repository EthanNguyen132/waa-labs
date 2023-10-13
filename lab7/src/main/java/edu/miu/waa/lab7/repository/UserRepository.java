package edu.miu.waa.lab7.repository;

import edu.miu.waa.lab7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String username);
}
