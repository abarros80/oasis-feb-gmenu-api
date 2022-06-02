package oasis.feb.gestaomenu.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tbl_restaurante")
public class Restaurante  implements Serializable{
	
	private static final long serialVersionUID = 1L;

    
    private long id;
    private String nome;
    private String telefone;
    private String numeroInterno;
    private String horario;
    private String imagemCapa;
    private Hotel hotel;
	private boolean activo;
    
	@Embedded
    private Log log;
    
    private List<RestauranteCardapio> restauranteCardapio;

	//ID-----------------------------------------------------------------	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//NOME-----------------------------------------------------------------
	@NotNull(message = "Campo NOME obrigatorio")
	@Size(min=3,max=40,message="NOME deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
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
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	//NUMERO INTERNO-----------------------------------------------------------------
	@NotNull(message = "Campo NUMERO INTERNO obrigatorio")
	@Size(min=3,max=4,message="NUMERO INTERNO deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")	
	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	//HORARIO-----------------------------------------------------------------
	@NotNull(message = "Campo HORARIO obrigatorio")
	@Size(min=1,max=100,message="HORARIO deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")		
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	//PATH IMAGEM-----------------------------------------------------------------
	@Size(max=300,message="PATH IMAGEM deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
	@Column(name = "imagem_capa",nullable = true, length=300)	
	public String getImagemCapa() {
		return imagemCapa;
	}

	public void setImagemCapa(String imagemCapa) {
		this.imagemCapa = imagemCapa;
	}
	
	

	//HOTEL----------------------------------------------------------------
	@NotNull(message = "HOTEL obrigatorio")
	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
	@OneToMany(mappedBy = "restaurante",cascade = CascadeType.ALL)
	public List<RestauranteCardapio> getRestauranteCardapio() {
		return restauranteCardapio;
	}

	public void setRestauranteCardapio(List<RestauranteCardapio> restauranteCardapio) {
		this.restauranteCardapio = restauranteCardapio;
	}
    
    

}
