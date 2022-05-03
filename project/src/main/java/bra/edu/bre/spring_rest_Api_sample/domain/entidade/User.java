package bra.edu.bre.spring_rest_Api_sample.domain.entidade;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
