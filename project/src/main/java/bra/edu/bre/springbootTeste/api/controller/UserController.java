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

    @GetMapping(value = "buscarPorId")
    public ResponseEntity<User> buscarPorId(@RequestParam Long idUser){
        User users = userServices.findById(idUser);
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "buscarPorNome")
    public ResponseEntity<List<User>> buscarPorNome(@RequestParam String nome){
        nome = nome.trim();
        if(!nome.isEmpty()){
            List<User> users = userServices.findAllByNome(nome.trim());
            return ResponseEntity.ok(users);
        }
        throw new RuntimeException("É necessário especificar pelo menos um valor");
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        user = userServices.save(user);
        return ResponseEntity.ok(user);
    }

//    @DeleteMapping(value = "delete/{id}")
//    @ResponseBody
//    public ResponseEntity<String> delete(@PathVariable Long id){
//        userServices.deleteById(id);
//        return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
//    }

    @DeleteMapping(value = "/delete")//mapeia a url
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUser){
        userServices.deleteById(idUser);
        return new ResponseEntity<String>("Excluído com sucesso", HttpStatus.OK);
    }

//    @PutMapping(value="/{id}")
//    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
//        User usuario = userServices.update(id, user);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(usuario);
//    }

    @PutMapping(value={"update", "atualizar"})
    public ResponseEntity<User> update(@RequestParam Long id, @RequestBody User user){
        User usuario = userServices.update(id, user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuario);
    }

    @GetMapping(value={"/login", "/log4j"})
    public ResponseEntity<String> login(@RequestParam(name = "login") String login, @RequestParam(name = "pass") String pass){
        if(userServices.autenticarUsuario(login, pass) == null){
            throw new RuntimeException("Login ou senha inválidos");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Login efetuado com sucesso");
    }
}
