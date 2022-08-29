package oasis.feb.gestaomenu.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_hotel")
public class Hotel implements Serializable{
	
	private static final long serialVersionUID = 1L;

    
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String imagemLogo;
	private boolean activo;
    
	@Embedded
    private Log log;
   
  	//Listas
    private List<User> users;
    
    //PARA TRANSFORMAR EM UNIDERECIONAL, COMEMTAR ESSES ATRIBUTOS
    private List<Restaurante> restaurantes;
    private List<Cardapio> cardapios;
    private List<Item> itens;
    

    //---------------GETTERS e SETTERS---------------------------------
    
    
    //ID-----------------------------------------------------------------
  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	//NOME-----------------------------------------------------------------

	@NotNull(message = "Campo NOME obrigatorio")
	@Size(min=3,max=100,message="NOME deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome", nullable = false, unique=true, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//TELEFONE-----------------------------------------------------------------
	@NotNull(message = "Campo TELEFONE obrigatorio")
	@Size(min=7,max=11,message="TELEFONE deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "telefone", nullable = false, unique=true, length=11)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//EMAIL-----------------------------------------------------------------
	@NotNull(message = "Campo EMAIL obrigatorio")
	@Size(min=5,max=50,message="EMAIL deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "email", nullable = false, unique=true, length=50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//PATH LOGO-----------------------------------------------------------------
	@Size(max=300,message="PATH LOGO deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
	@Column(name = "logo_path",nullable = true, length=300)
	public String getImagemLogo() {
		return imagemLogo;
	}

	public void setImagemLogo(String imagemLogo) {
		this.imagemLogo = imagemLogo;
	}
	
	//ACTIVO----------------------------------------------------------------
	@NotNull(message = "Campo ACTIVO obrigatorio")
	@Column(name = "activo", nullable = false, columnDefinition="bit(1) default 1")
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	//LOG-----------------------------------------------------------------------
	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
	
	
	//----------------------LISTAS------------------------------------------
	

	//BIDERECIONAL
	//USERS-----------------------------------------------------------------
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "user_hotels",
	        joinColumns = @JoinColumn(name = "hotel_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	//PARA ANALISAR, CASO DE LOOP TRANSFORMAR EM UNIDERECIONAL:
	//RESTAURANTES-----------------------------------------------------------------
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	
	//PARA ANALISAR, CASO DE LOOP TRANSFORMAR EM UNIDERECIONAL:
	//CARDAPIO-------------------------------------------------------------
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}

	//PARA ANALISAR, CASO DE LOOP TRANSFORMAR EM UNIDERECIONAL:
	//ITENS-----------------------------------------------------------------
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	
	//HASCODE E EQUAL

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return id == other.id;
	}

	
	//TO STRING
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", imagemLogo="
				+ imagemLogo +  "]";
	}
	
	
	
	
	
	
	
    
    

}
