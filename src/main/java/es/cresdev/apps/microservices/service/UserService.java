package es.cresdev.apps.microservices.service;

import es.cresdev.apps.microservices.model.user.User;
import es.cresdev.apps.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*
    @Autowired
    private AtlasModelValidationFactory modelValidationFactory;

    private ModelValidation<User> userModelValidation;

    public UserService() throws ModelValidationNotImplementedException {
        userModelValidation = modelValidationFactory.buildModelValidation(User.class);
    }
    */

    public List<User> allUsers() {
        ArrayList<User> results = new ArrayList<>();

        try {
            userRepository.findAll().forEach(results::add);
        }
        catch (Exception ignored) {

        }

        return results;
    }

    public User userDetails(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        User entity = userDetails(user.getEmail());

        if (entity == null) {
            entity = userRepository.save(user);
        }

        return entity;
    }

    public User saveUser(User user) {
        User entity = userDetails(user.getEmail());

        if (entity != null) {
            user.setId(entity.getId());
            entity = userRepository.save(user);
        }

        return entity;
    }

    public boolean deleteUser(String email) {
        User entity = userDetails(email);
        boolean isUserDeleted = false;

        if (entity != null) {
            userRepository.delete(entity);

            // Search again for the user
            User oldUserEntity = userDetails(email);

            isUserDeleted = oldUserEntity == null;
        }

        return isUserDeleted;
    }

}