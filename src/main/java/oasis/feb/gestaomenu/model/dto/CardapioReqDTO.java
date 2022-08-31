package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import oasis.feb.gestaomenu.model.Hotel;

public class CardapioReqDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//ID-----------------------------------------------------------------
    private Long id;  
    
    //NOMEPT----------------------------------------------------------------		
  	@NotNull(message = "Campo Nome em PT obrigatorio")
  	@Size(min=3,max=30,message="Nome em PT deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
  	+ "${validatedValue}")
    private String nomePt;
  	
	//NOMEING----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em ING obrigatorio")
	@Size(min=3,max=30,message="Nome em ING deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")  	
    private String nomeIng;
	
	//NOMEFR----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em FR obrigatorio")
	@Size(min=3,max=30,message="Nome em FR deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")	
    private String nomeFr;
	
	//CODIGO REDUZIDO----------------------------------------------------------------		
	@NotNull(message = "Campo CODIGO REDUZIDO obrigatorio")
	@Size(max=4,message="CODIGO REDUZIDO deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")	
    private String codigoReduzido;
	
	//HOTEL----------------------------------------------------------------
	@NotNull(message = "HOTEL obrigatorio")	
    private Hotel hotel;    
	
	//ACTIVO----------------------------------------------------------------
	@NotNull(message = "Campo ACTIVO obrigatorio")
    private boolean activo;
	
	//PATH IMAGEM-----------------------------------------------------------------
	@Size(max=300,message="PATH IMAGEM deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
    private String imagem;
    
    //log
  	@NotNull(message = "Campo USER obrigatorio")
  	private Long  idUser;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePt() {
		return nomePt;
	}
	public void setNomePt(String nomePt) {
		this.nomePt = nomePt;
	}
	public String getNomeIng() {
		return nomeIng;
	}
	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}
	public String getNomeFr() {
		return nomeFr;
	}
	public void setNomeFr(String nomeFr) {
		this.nomeFr = nomeFr;
	}
	public String getCodigoReduzido() {
		return codigoReduzido;
	}
	public void setCodigoReduzido(String codigoReduzido) {
		this.codigoReduzido = codigoReduzido;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
    
    
    

}
