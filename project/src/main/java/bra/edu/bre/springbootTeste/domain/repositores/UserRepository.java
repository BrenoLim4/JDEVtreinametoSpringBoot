package bra.edu.bre.springbootTeste.domain.repositores;

import bra.edu.bre.springbootTeste.domain.entidade.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByNomeContains(String nome);

    //3 formas de ser feita a consulta
    //1
    @Transactional(readOnly = true)
    @Query(value = "select u from User u where u.login = ?1 and u.senha = ?2")
    User userAutenticate(String login, String senha);
    //2

    @Transactional(readOnly = true)
    @Query(value = "select u from User u where u.login = :login and u.senha = :senha")
    User userAutenticateParam(@Param("login") String login, @Param("senha") String senha);
    //3
    User findUserByLoginAndSenha(String login, String senha);

    @Modifying
    @Transactional(timeout = 3, rollbackFor = {SQLException.class, NullPointerException.class, IllegalArgumentException.class})
    @Query(value = "delete from User u where u.login = ?1 and u.senha = ?2")
    void deleteUsuarioWithParam(String login, String senha);

    @Modifying
    @Transactional
    @Query(value = "update User set login = :login, senha = :senha where id = :id")
    void updateLoginAndSenhaPorId(@Param(value = "login") String login, @Param(value = "senha") String senha, @Param(value = "id") Long id);

}
