package es.cresdev.apps.microservices.rest;

import es.cresdev.apps.microservices.model.user.User;
import es.cresdev.apps.microservices.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> userList() {
        List<User> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User response = userService.createUser(user);

        if (response == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        User response = userService.saveUser(user);

        if (response == null) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity deleteUser(@PathVariable("email") String email) {
        boolean response = userService.deleteUser(email);

        if (!response) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok().build();
    }




}
