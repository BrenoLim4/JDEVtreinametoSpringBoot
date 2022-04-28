package bra.edu.bre.springbootTeste;

import bra.edu.bre.springbootTeste.domain.entidade.User;
import bra.edu.bre.springbootTeste.domain.services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;

    @Test
    void findByNome(){
        userServices.findAllByNome("Francisco").forEach(System.out::println);
    }

    @Test
    void autenticate(){
        String login = "teste", senha = "teste";
        User user = userServices.autenticarUsuario(login, senha);
        Assert.notNull(user, "Query sem Param");
        System.out.println(user);
        user = userServices.autenticarUsuarioWithParam(login, senha);
        Assert.notNull(user, "Query com Param");
        System.out.println(user);
        user = userServices.autenticarUsuarioNewMethod(login, senha);
        Assert.notNull(user);
        System.out.println(user);
    }

    @Test
    void deletarUsuario(){
        String login = "teste", senha = "teste";
        userServices.deletarUsuario(login, senha);
    }

    @Test
    void delete(){
        userServices.deleteById(10L);
    }

    @Test
    void updateLoginESenha(){
        userServices.updateLoginESenhaPorId("99039833", "23112000", 10L);
    }

}
