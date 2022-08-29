package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HotelReqDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//DADOS DE ENTRADA, VINDOS DO FORMULARIO, FRONTOFFICE (Ñ deveria ter o ID)
	
	
    
    private Long id;
    
   //NOME-----------------------------------------------------------------

  	@NotNull(message = "Campo NOME obrigatorio")
  	@Size(min=3,max=100,message="NOME deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
  	+ "${validatedValue}")
    private String nome;
  	
  	
    //TELEFONE-----------------------------------------------------------------
  	@NotNull(message = "Campo TELEFONE obrigatorio")
  	@Size(min=7,max=11,message="TELEFONE deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
  	+ "${validatedValue}")
    private String telefone;
  	
	//EMAIL-----------------------------------------------------------------
	@NotNull(message = "Campo EMAIL obrigatorio")
	@Size(min=5,max=50,message="EMAIL deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")  	
    private String email;
	
	
	//PATH LOGO-----------------------------------------------------------------
	@Size(max=300,message="PATH LOGO deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")	
    private String imagemLogo;

	//ACTIVO----------------------------------------------------------------
	@NotNull(message = "Campo ACTIVO obrigatorio")	
	boolean activo;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagemLogo() {
		return imagemLogo;
	}

	public void setImagemLogo(String imagemLogo) {
		this.imagemLogo = imagemLogo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
	
	
	

}
