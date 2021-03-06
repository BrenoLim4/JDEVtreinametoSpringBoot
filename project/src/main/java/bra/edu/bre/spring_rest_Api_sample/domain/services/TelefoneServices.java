package bra.edu.bre.spring_rest_Api_sample.domain.services;

import bra.edu.bre.spring_rest_Api_sample.domain.entidade.Telefone;
import bra.edu.bre.spring_rest_Api_sample.domain.repositores.TelefoneRepository;
import bra.edu.bre.spring_rest_Api_sample.domain.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServices {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public Telefone save(Telefone telefone){
        return telefoneRepository.save(telefone);
    }

    public void delete(Telefone telefone){
        telefoneRepository.delete(telefone);
    }

    public void deleteById(Long id){
        telefoneRepository.deleteById(id);
    }

    public List<Telefone> findAll(){
        return telefoneRepository.findAll();
    }

    public Telefone findById(Long id) throws ResourceNotFoundException{
        return telefoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
