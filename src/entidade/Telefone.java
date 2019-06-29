package entidade;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class Telefone implements Serializable {

    @Id
    @Column(name = "NUMERO_TELEFONE")
    @GeneratedValue(generator = "ID_TELEFONE")
    @SequenceGenerator(name = "ID_TELEFONE", sequenceName = "ID_TELEFONE", allocationSize = 5)
    private String numero;

    @Column(name = "DDD", nullable = false)
    private Integer ddd;

    @Column(name = "TIPO", nullable = false)
    private String tipo;

    public Telefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
