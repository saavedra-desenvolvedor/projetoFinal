package com.lojaunitAJ.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Clientes implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)  
	  private Integer id;
	  
	  @NotNull(message="Nome deve ser preenchido") 
	  @NotEmpty(message="Nome não pode ser vazio") 
	  @Size(min=2, max=200, message="Nome deve ter entre 2 e 200 caracteres")
	  private String nome;
	  
	  @NotNull(message="Cpf deve ser preenchido") 
	  @NotEmpty(message="Cpf não pode ser vazio") 
	  @Size(min=11, max=11, message="Nome deve ter 11 caracteres")
	  private String cpf;
	  
	  @NotNull(message="E-mail deve ser preenchido") 
	  @NotEmpty(message="E-mail não pode ser vazio") 
	  @Size(min=6, max=200, message="E-mail deve ter entre 6 e 200  caracteres")
	  private String email;
	  
	  @Past(message="A data de nascimento deve ser anterior a data atual.") 
	  //@DateTimeFormat(pattern="dd/MM/yyyy")
	 
	  private Date dataNascimento; 
	  
	  private String sexo;
	  private String nomeSocial;
	  private String apelido;
	  private String telefone;
	  
	//  @OneToMany(mappedBy = "clientes")
	//    private List<Venda> vendas;
	    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
}
