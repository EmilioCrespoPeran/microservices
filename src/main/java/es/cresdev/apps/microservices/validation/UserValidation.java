package es.cresdev.apps.microservices.validation;

import es.cresdev.apps.microservices.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidation implements ModelValidation<User> {

    @Override
    public boolean isValid(User model) {
        return false;
    }

}
