package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import oasis.feb.gestaomenu.model.Hotel;
import oasis.feb.gestaomenu.model.TipoItem;
import oasis.feb.gestaomenu.model.enums.UnidadeMedidaEnum;

public class ItemReqDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//DADOS DE ENTRADA, VINDOS DO FORMULARIO, FRONTOFFICE (Ñ deveria ter o ID)
	
	private Long id;
	
	//@JsonIgnore
	@NotNull(message = "Campo TIPO ITEM obrigatorio")
	private TipoItem tipoItem;
	
	@NotNull(message = "Campo ACTIVO obrigatorio")
	private boolean activo;
	
	
	private Hotel hotel;
	
	//Nome Item
	
	@NotNull(message = "Campo Nome em PT obrigatorio")
	@Size(min=3,max=40,message="Nome em PT deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	private String nomePt;
	
	@Size(max=40,message="Nome em ING deve ter no máximo {max} caracteres. Você digitou: "
			+ "${validatedValue}")
    private String nomeIng;
	
	@Size(max=40,message="Nome em FR deve ter no máximo {max} caracteres. Você digitou: "
			+ "${validatedValue}")
    private String nomeFr;

	
	//Path foto
	@Size(max=300,message="PATH FOTO deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
	private String fotoPath;
	
	//Descrições/Composição
	@Size(max=300,message="DescPt deve ter no máximo {max} caracteres. Você digitou: "
			+ "${validatedValue}")
	private String descPt;
	
	@Size(max=300,message="DescFr deve ter no máximo {max} caracteres. Você digitou: "
			+ "${validatedValue}")
	private String descFr;
	
	@Size(max=300,message="DescIng deve ter no máximo {max} caracteres. Você digitou: "
			+ "${validatedValue}")
	private String descIng;
	
	//Preço/Quantidade
	@NotNull(message = "Campo PRECO obrigatorio")
	private float preco;
	
	@NotNull(message = "Campo QUANTIDADE obrigatorio")
	private float quantidade;
	
	@NotNull(message = "Campo UNIDD MEDIDA obrigatorio")
	private UnidadeMedidaEnum unidadeMedidaEnum;
	
	//log
	@NotNull(message = "Campo USER obrigatorio")
	private Long  idUser;
	
	//GETTERS SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public boolean getActivo() {
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

	public String getFotoPath() {
		return fotoPath;
	}

	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}

	public String getDescPt() {
		return descPt;
	}

	public void setDescPt(String descPt) {
		this.descPt = descPt;
	}

	public String getDescFr() {
		return descFr;
	}

	public void setDescFr(String descFr) {
		this.descFr = descFr;
	}

	public String getDescIng() {
		return descIng;
	}

	public void setDescIng(String descIng) {
		this.descIng = descIng;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedidaEnum getUnidadeMedidaEnum() {
		return unidadeMedidaEnum;
	}

	public void setUnidadeMedidaEnum(UnidadeMedidaEnum unidadeMedidaEnum) {
		this.unidadeMedidaEnum = unidadeMedidaEnum;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
	


}
