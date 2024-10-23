package cl.company.apiuserservice.controller;

import cl.company.apiuserservice.exception.ErrorResponse;
import cl.company.apiuserservice.model.Users;
import cl.company.apiuserservice.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> findAllUsers() {
        log.info("Se solicita la lista de todas los usuarios");
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findUser/{id}")
    public ResponseEntity<Object> findUser(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id)) || id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }
        return ResponseEntity.ok(userService.findUser(id));
    }

    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users users,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (users == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(userService.createUser(users));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody Users users,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (users == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(userService.createUser(users));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Algunos de los parámetros no se ingresaron"));
        }


        Users users = userService.findUser(id);

        if (users != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok(new ErrorResponse("Libro eliminado"));
        } else {
            log.info("Libro no encontrado con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Libro no encontrado"));
        }
    }


}
