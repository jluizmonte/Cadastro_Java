package entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CADASTRO")
public class Cadastro {

	@Id
	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "SENHA")
	private String senha;

	@JoinColumn(name = "DDD", referencedColumnName = "DDD")
	@ManyToOne(cascade = CascadeType.ALL)
	private Telefone ddd;

	@JoinColumn(name = "NUMERO_TELEFONE", referencedColumnName = "NUMERO")
	@ManyToOne(cascade = CascadeType.ALL)
	private Telefone numero;

	@JoinColumn(name = "TIPO", referencedColumnName = "TIPO")
	@ManyToOne(cascade = CascadeType.ALL)
	private Telefone tipo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Telefone getDdd() {
		return ddd;
	}

	public void setDdd(Telefone ddd) {
		this.ddd = ddd;
	}
        public Telefone getNumero() {
		return numero;
	}

	public void setNumero(Telefone numero) {
		this.numero = numero;
	}

}
