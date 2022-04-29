package bra.edu.bre.springbootTeste.domain.entidade;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
//@Builder
@Entity
@ToString
@Table(name = "user", schema = "spring_data")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column
    private String nome;
    @Column
    private String login;
    @Column
    private String senha;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Telefone> telefones;
}
