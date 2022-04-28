package bra.edu.bre.springbootTeste.api.controller;

import bra.edu.bre.springbootTeste.domain.entidade.User;
import bra.edu.bre.springbootTeste.domain.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userServices.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<List<User>> findAllByName(@PathVariable String nome){
        List<User> users = userServices.findAllByNome(nome);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userServices.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        User usuario = userServices.update(id, user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }

}
