package bra.edu.bre.springbootTeste;

import bra.edu.bre.springbootTeste.domain.entidade.Telefone;
import bra.edu.bre.springbootTeste.domain.services.TelefoneServices;
import bra.edu.bre.springbootTeste.domain.services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TelefoneServicesTest {

    @Autowired
    private TelefoneServices telefoneServices;
    @Autowired
    private UserServices userServices;

    @Test
    public void save(){
        Telefone telefone = new Telefone.TelefoneBuilder()
                                .setNumero("32894323")
                                .setTipo("Fixo")
                                .setUsuario(userServices.findById(12L))
                                .get();
        telefone = telefoneServices.save(telefone);
        System.out.println(telefone);
    }

    @Test
    public void findAll(){
        telefoneServices.findAll().forEach(System.out::println);
    }

    @Test
    public void deleteById(){
        telefoneServices.deleteById(5L);
    }

    @Test
    public void delete(){
        Telefone telefone = telefoneServices.findById(6L);
        telefoneServices.delete(telefone);
    }
}
