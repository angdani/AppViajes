// Paquete donde se encuentra el controlador
package com.DanielPons.AppTrip.controller;

// Importación de clases necesarias
import com.DanielPons.AppTrip.model.User;
import com.DanielPons.AppTrip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Anotación que indica que esta clase es un controlador REST (devuelve JSON)
@RestController
// Define la ruta base de los endpoints de esta clase
@RequestMapping("/api/users")
public class UserController {

    // Inyección del servicio de usuarios
    private final UserService userService;

    // Constructor con inyección automática del servicio
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para crear un nuevo usuario: POST /api/users
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Llama al servicio para crear el usuario
        User createdUser = userService.createUser(user);
        // Devuelve el usuario creado con código 200 OK
        return ResponseEntity.ok(createdUser);
    }

}
