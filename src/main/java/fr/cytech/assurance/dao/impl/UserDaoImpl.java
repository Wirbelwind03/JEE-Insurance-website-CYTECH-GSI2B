package fr.cytech.assurance.dao.impl;

import fr.cytech.assurance.dao.UserDao;
import fr.cytech.assurance.model.User;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {
    public UserDaoImpl(){
        super(User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return session().createSelectionQuery(
                        "from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .uniqueResultOptional();
    }

    @Override
    public List<User> findByRole(String role) {
        return session().createSelectionQuery(
                        "from User u where u.role.nom = :r", User.class)
                .setParameter("r", role)
                .getResultList();

    }
}
