package bra.edu.bre.springbootTeste.domain.repositores;

import bra.edu.bre.springbootTeste.domain.entidade.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNullApi;
import org.springframework.transaction.annotation.Transactional;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from Telefone where id = :id")
    void deleteById(@Param("id")  Long id);
}
