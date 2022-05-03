package bra.edu.bre.spring_rest_Api_sample.domain.entidade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefone", schema = "spring_data")
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String numero;
//    @ManyToOne
//    @JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    public static class TelefoneBuilder{

        private String tipo;
        private String numero;
        private Long usuario;

        public TelefoneBuilder(){

        }

        public TelefoneBuilder setTipo(String tipo){
            this.tipo = tipo;
            return this;
        }

        public TelefoneBuilder setNumero(String numero){
            this.numero = numero;
            return this;
        }

        public TelefoneBuilder setUsuario(Long usuario){
            this.usuario = usuario;
            return this;
        }

        public Telefone get(){
            return new Telefone(null, tipo, numero, usuario);
        }
    }
}
