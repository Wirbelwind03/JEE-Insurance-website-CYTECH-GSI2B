package fr.cytech.assurance.service;

import fr.cytech.assurance.dao.UserDao;
import fr.cytech.assurance.dao.impl.UserDaoImpl;
import fr.cytech.assurance.dto.request.RegisterRequest;
import fr.cytech.assurance.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    private final UserDao users = new UserDaoImpl();

    public void register(RegisterRequest registerRequest){
        if (users.findByEmail(registerRequest.getEmail()).isPresent()){

        }

        User user = new User(
                registerRequest.getFirstName(),
                registerRequest.getName(),
                registerRequest.getEmail(),
                registerRequest.getPhoneNumber(),
                registerRequest.getBirthDate(),
                registerRequest.getAddress(),
                BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt())
        );

        users.save(user);
    }
}
