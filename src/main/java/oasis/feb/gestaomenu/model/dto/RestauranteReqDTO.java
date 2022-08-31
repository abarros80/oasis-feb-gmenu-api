package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import oasis.feb.gestaomenu.model.Hotel;

public class RestauranteReqDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//ID-----------------------------------------------------------------
    private Long id;
    
    //NOME-----------------------------------------------------------------
  	@NotNull(message = "Campo NOME obrigatorio")
  	@Size(min=3,max=40,message="NOME deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
  	+ "${validatedValue}")
    private String nome;
  	
  	//TELEFONE-----------------------------------------------------------------
  	@NotNull(message = "Campo TELEFONE obrigatorio")
  	@Size(min=7,max=11,message="TELEFONE deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
  	+ "${validatedValue}")
    private String telefone;
  	
	//NUMERO INTERNO-----------------------------------------------------------------
	@NotNull(message = "Campo NUMERO INTERNO obrigatorio")
	@Size(min=3,max=4,message="NUMERO INTERNO deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")	  	
    private String numeroInterno;
	
	//HORARIO-----------------------------------------------------------------
	@NotNull(message = "Campo HORARIO obrigatorio")
	@Size(min=1,max=100,message="HORARIO deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")		
    private String horario;
	
	//PATH IMAGEM-----------------------------------------------------------------
	@Size(max=300,message="PATH IMAGEM deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
    private String imagemCapa;
	
	//ACTIVO----------------------------------------------------------------
	@NotNull(message = "Campo ACTIVO obrigatorio")
	private boolean activo;
	
	//HOTEL----------------------------------------------------------------
	@NotNull(message = "HOTEL obrigatorio")	
	private Hotel hotel;
	
	//log
	@NotNull(message = "Campo USER obrigatorio")
	private Long  idUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getImagemCapa() {
		return imagemCapa;
	}

	public void setImagemCapa(String imagemCapa) {
		this.imagemCapa = imagemCapa;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	

}
