package oasis.feb.gestaomenu.model;


import java.io.Serializable;
import java.time.LocalDateTime;


import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String nome;
	private boolean activo;
	private int ordem;
	private Conjunto pai;
	private TipoItem tipoItem;

	
	//Dados especificos de um item de Menu
	private String fotoPath;
	
	private String descPt;
	private String descFr;
	private String descIng;
	
	private float preco;
	private float quantidade;
	
	private UnidadeMedidaEnum unidadeMedidaEnum;
	
	//Log cadastro
	private LocalDateTime dataCadastro;
	private Long  idUserCadastro;
	
	public Item() {}
	
	
	

	public Item(String nome, boolean activo, int ordem, Conjunto pai, TipoItem tipoItem, String fotoPath, String descPt,
			String descFr, String descIng, float preco, float quantidade, UnidadeMedidaEnum unidadeMedidaEnum, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.ordem = ordem;
		this.pai = pai;
		this.tipoItem = tipoItem;
		this.fotoPath = fotoPath;
		this.descPt = descPt;
		this.descFr = descFr;
		this.descIng = descIng;
		this.preco = preco;
		this.quantidade = quantidade;
		this.unidadeMedidaEnum = unidadeMedidaEnum;
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
	}



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

	

	//NOME----------------------------------------------------------------

	@NotNull(message = "Campo NOME obrigatorio")
	@Size(min=3,max=100,message="NOME deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "nome", nullable = false, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	//ORDEM----------------------------------------------------------------
	@NotNull(message = "Campo ORDEM obrigatorio")
	@Column(name = "ordem", nullable = false)
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	//PAI----------------------------------------------------------------

	//@JsonIgnore
	@NotNull(message = "Campo PAI obrigatorio")
	@ManyToOne
	@JoinColumn(name = "conjunto_id", nullable = false)
	public Conjunto getPai() {
		return pai;
	}

	public void setPai(Conjunto pai) {
		this.pai = pai;
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
	@NotNull(message = "Campo descrição em PT obrigatorio")
	@Size(min=5,max=300,message="DescPt deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_pt", nullable = false, length=300)
	public String getDescPt() {
		return descPt;
	}

	public void setDescPt(String desc_pt) {
		this.descPt = desc_pt;
	}


	//DESCFR----------------------------------------------------------------
	@NotNull(message = "Campo descrição em FR obrigatorio")
	@Size(min=5,max=300,message="DescFr deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_fr", nullable = false, length=300)
	public String getDescFr() {
		return descFr;
	}

	public void setDescFr(String desc_fr) {
		this.descFr = desc_fr;
	}

	
	//DESCING----------------------------------------------------------------
	@NotNull(message = "Campo descrição em ING obrigatorio")
	@Size(min=5,max=300,message="DescIng deve ter no máximo {max} caracteres e no minimo" + " {min} caracteres. Você digitou: "
	+ "${validatedValue}")
	@Column(name = "desc_ing", nullable = false, length=300)
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
	
	
	//DATA CADASTRO--------------------------------------------------------
	@NotNull(message = "Campo DATA CADASTRO obrigatorio")
	@Column(name = "data_cadastro",nullable = false)
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	//ID USER CADASTRO--------------------------------------------------------
	@NotNull(message = "Campo USER CADASTRO obrigatorio")
	@Column(name = "id_user_cadastro",nullable = false)
	public Long getIdUserCadastro() {
		return idUserCadastro;
	}

	public void setIdUserCadastro(Long idUserCadastro) {
		this.idUserCadastro = idUserCadastro;
	}
	

	
	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", activo=" + activo + ", ordem=" + ordem + ", preco=" + preco
				+ ", quantidade=" + quantidade + ", unidadeMedidaEnum=" + unidadeMedidaEnum + ", dataCadastro="
				+ dataCadastro + ", idUserCadastro=" + idUserCadastro + "]";
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
