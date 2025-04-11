package group3.p4enlistment.repository;


import group3.p4enlistment.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo {
    Optional<User> findByUsername(String username);
}
