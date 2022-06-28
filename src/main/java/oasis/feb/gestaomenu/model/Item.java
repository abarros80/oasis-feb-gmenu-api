package oasis.feb.gestaomenu.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import oasis.feb.gestaomenu.model.enums.UnidadeMedidaEnum;


@Entity
@Table(name = "tbl_item")
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nomePt;
    private String nomeIng;
    private String nomeFr;
	private boolean activo;
	private TipoItem tipoItem;
	
	private Hotel hotel;

	
	//Dados especificos de um item de Menu
	private String fotoPath;
	
	private String descPt;
	private String descFr;
	private String descIng;
	
	private float preco;
	private float quantidade;
	
	private UnidadeMedidaEnum unidadeMedidaEnum;
	
    @Embedded
    private Log log;
	
	private List<ItemCardapio> itemCardapio;
	
	
	
	public Item() {}
	
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

	

	//NOMEPT----------------------------------------------------------------		
	@NotNull(message = "Campo Nome em PT obrigatorio")
	@Size(min=3,max=40,message="Nome em PT deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_pt", unique = true, nullable = false, length=40)
	public String getNomePt() {
		return nomePt;
	}

	public void setNomePt(String nomePt) {
		this.nomePt = nomePt;
	}

	//NOMEING----------------------------------------------------------------		
	@Size(max=40,message="Nome em ING deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_ing", unique = true, nullable = true, length=40)
	public String getNomeIng() {
		return nomeIng;
	}

	public void setNomeIng(String nomeIng) {
		this.nomeIng = nomeIng;
	}

	//NOMEFR----------------------------------------------------------------		
	@Size(max=40,message="Nome em FR deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome_fr", unique = true, nullable = true, length=40)
	public String getNomeFr() {
		return nomeFr;
	}

	public void setNomeFr(String nomeFr) {
		this.nomeFr = nomeFr;
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


	//TIPO ITEM------------------------------------------------------------

	//@JsonIgnore
	@NotNull(message = "Campo TIPO ITEM obrigatorio")
	@ManyToOne
	@JoinColumn(name = "tipo_item_id", nullable = false)
	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}
	
	
	//PATH FOTO------------------------------------------------------------
	
	@Size(max=300,message="PATH FOTO deve ter no máximo {max} caracteres. Você digitou: " + "${validatedValue}")
	@Column(name = "foto_path",nullable = true, length=300)
	public String getFotoPath() {
		return fotoPath;
	}

	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}

	//DESCPT----------------------------------------------------------------
	@Size(max=300,message="DescPt deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_pt", nullable = true, length=300)
	public String getDescPt() {
		return descPt;
	}

	public void setDescPt(String desc_pt) {
		this.descPt = desc_pt;
	}


	//DESCFR----------------------------------------------------------------
	@Size(max=300,message="DescFr deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_fr", nullable = true, length=300)
	public String getDescFr() {
		return descFr;
	}

	public void setDescFr(String desc_fr) {
		this.descFr = desc_fr;
	}

	
	//DESCING----------------------------------------------------------------
	@Size(max=300,message="DescIng deve ter no máximo {max} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_ing", nullable = true, length=300)
	public String getDescIng() {
		return descIng;
	}

	public void setDescIng(String desc_ing) {
		this.descIng = desc_ing;
	}

	//PRECO----------------------------------------------------------------
	@NotNull(message = "Campo PRECO obrigatorio")
	@Column(name = "preco", nullable = false)
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	//QUANTIDADE------------------------------------------------------------
	@NotNull(message = "Campo QUANTIDADE obrigatorio")
	@Column(name = "quantidade", nullable = false)
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	
	//UnidadeMedidaEnum------------------------------------------------------
	@NotNull(message = "Campo UNIDD MEDIDA obrigatorio")
	@Enumerated(EnumType.STRING)
	@Column(name = "unidade_medida_enum", nullable = false)
	public UnidadeMedidaEnum getUnidadeMedidaEnum() {
		return unidadeMedidaEnum;
	}

	public void setUnidadeMedidaEnum(UnidadeMedidaEnum unidadeMedidaEnum) {
		this.unidadeMedidaEnum = unidadeMedidaEnum;
	}
	
	
	//LOG-----------------------------------------------------------------------
	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
	//HOTEL-------------------------------------------------------
	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	@OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
	public List<ItemCardapio> getItemCardapio() {
		return itemCardapio;
	}

	public void setItemCardapio(List<ItemCardapio> itemCardapio) {
		this.itemCardapio = itemCardapio;
	}
	

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nomePt + ", activo=" + activo + ", preco=" + preco
				+ ", quantidade=" + quantidade + ", unidadeMedidaEnum=" + unidadeMedidaEnum + "]";
	}




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
		Item other = (Item) obj;
		return id == other.id;
	}
	
	

}
