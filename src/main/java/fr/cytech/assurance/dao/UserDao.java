package fr.cytech.assurance.dao;

import fr.cytech.assurance.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
}
