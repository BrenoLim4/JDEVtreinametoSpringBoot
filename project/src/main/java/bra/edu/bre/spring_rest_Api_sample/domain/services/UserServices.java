package bra.edu.bre.spring_rest_Api_sample.domain.services;

import bra.edu.bre.spring_rest_Api_sample.domain.entidade.User;
import bra.edu.bre.spring_rest_Api_sample.domain.repositores.UserRepository;
import bra.edu.bre.spring_rest_Api_sample.domain.services.exception.DataBaseException;
import bra.edu.bre.spring_rest_Api_sample.domain.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) throws ResourceNotFoundException{
        final Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<User> findAllByNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public void delete(User obj) {
        try {
            repository.delete(obj);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User autenticarUsuario(String login, String senha){
        return repository.userAutenticate(login, senha);
    }

    public User autenticarUsuarioWithParam(String login, String senha){
        return repository.userAutenticateParam(login, senha);
    }

    public User autenticarUsuarioNewMethod(String login, String senha){
        return repository.findUserByLoginAndSenha(login, senha);
    }

    public void deletarUsuario(String login, String senha){
        repository.deleteUsuarioWithParam(login, senha);
    }

    public void updateLoginESenhaPorId(String login, String senha, Long id){
        repository.updateLoginAndSenhaPorId(login, senha, id);
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User save(User obj) {
        try {
            return repository.save(obj);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj);
        }
    }

    public User update(Long id, User obj) {
        obj.setId(id);
        return save(obj);
    }

    public Long count() {
        return repository.count();
    }

}
