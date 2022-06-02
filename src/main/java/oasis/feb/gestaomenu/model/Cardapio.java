package oasis.feb.gestaomenu.model;

import java.io.Serializable;
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


@Entity
@Table(name = "tbl_cardapio")
public class Cardapio implements Serializable{
	
	private static final long serialVersionUID = 1L;

    
    private long id;   
    private String nomePt;
    private String nomeIng;
    private String nomeFr;
    private String codigoReduzido;
    private Hotel hotel;    
    private boolean activo;
    private String imagem;
    
    @Embedded
    private Log log;
    
	
	private List<RestauranteCardapio> restauranteCardapio;	
	private List<ItemCardapio> itemCardapio;
	
	
	
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
	
	//NOMEPT----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em PT obrigatorio")
	@Size(min=3,max=30,message="Nome em PT deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_pt", nullable = false, length=30)
	public String getNomePt() {
		return nomePt;
	}

	public void setNomePt(String nomePt) {
		this.nomePt = nomePt;
	}

	//NOMEING----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em ING obrigatorio")
	@Size(min=3,max=30,message="Nome em ING deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_ing", nullable = false, length=30)
	public String getNomeIng() {
		return nomeIng;
	}

	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}

	//NOMEFR----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em FR obrigatorio")
	@Size(min=3,max=30,message="Nome em FR deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_fr", nullable = false, length=30)
	public String getNomeFr() {
		return nomeFr;
	}

	public void setNomeFr(String nomeFr) {
		this.nomeFr = nomeFr;
	}

	//CODIGO REDUZIDO----------------------------------------------------------------		
	@NotNull(message = "Campo CODIGO REDUZIDO obrigatorio")
	@Size(max=4,message="CODIGO REDUZIDO deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "cod_reduz", nullable = false, length=4)
	public String getCodigoReduzido() {
		return codigoReduzido;
	}

	public void setCodigoReduzido(String codigoReduzido) {
		this.codigoReduzido = codigoReduzido;
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
	
	
	//PATH IMAGEM-----------------------------------------------------------------
	@Size(max=300,message="PATH IMAGEM deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
	@Column(name = "imagem_path",nullable = true, length=300)	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	//LOG-----------------------------------------------------------------------
	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
		

	//----------------------LISTAS------------------------------------------
	
	//RESTAURANTECARDAPIO
	@OneToMany(mappedBy = "cardapio",cascade = CascadeType.ALL)
	public List<RestauranteCardapio> getRestauranteCardapio() {
		return restauranteCardapio;
	}

	public void setRestauranteCardapio(List<RestauranteCardapio> restauranteCardapio) {
		this.restauranteCardapio = restauranteCardapio;
	}


	//ITEMCARDAPIO
	@OneToMany(mappedBy = "cardapio",cascade = CascadeType.ALL)
	public List<ItemCardapio> getItemCardapio() {
		return itemCardapio;
	}

	public void setItemCardapio(List<ItemCardapio> itemCardapio) {
		this.itemCardapio = itemCardapio;
	}

	

}
