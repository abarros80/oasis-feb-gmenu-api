package oasis.feb.gestaomenu.model;


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
import com.fasterxml.jackson.annotation.JsonIgnore;

import oasis.feb.gestaomenu.model.enums.UnidadeMedidaEnum;


@Entity
@Table(name = "tbl_item")
public class Item {
	
	private long id;
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
	private long  idUserCadastro;
	
	public Item() {}
	
	
	

	public Item(String nome, boolean activo, int ordem, Conjunto pai, TipoItem tipoItem, String fotoPath, String descPt,
			String descFr, String descIng, float preco, float quantidade, UnidadeMedidaEnum unidadeMedidaEnum, LocalDateTime dataCadastro, long  idUserCadastro) {
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
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	//NOME----------------------------------------------------------------

	@Column(name = "nome", nullable = false, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	//ACTIVO----------------------------------------------------------------

	@Column(name = "activo", nullable = false, columnDefinition="bit(1) default 1")
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	//ORDEM----------------------------------------------------------------

	@Column(name = "ordem", nullable = false)
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	//PAI----------------------------------------------------------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conjunto_id", nullable = false)
	public Conjunto getPai() {
		return pai;
	}

	public void setPai(Conjunto pai) {
		this.pai = pai;
	}
	
	
	//TIPO ITEM------------------------------------------------------------

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tipo_item_id", nullable = false)
	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	//PATH FOTO------------------------------------------------------------

	@Column(name = "foto_path",nullable = false)
	public String getFotoPath() {
		return fotoPath;
	}

	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}

	//DESCPT----------------------------------------------------------------

	@Column(name = "desc_pt", nullable = false, length=300)
	public String getDescPt() {
		return descPt;
	}

	public void setDescPt(String desc_pt) {
		this.descPt = desc_pt;
	}


	//DESCFR----------------------------------------------------------------

	@Column(name = "desc_fr", nullable = false, length=300)
	public String getDescFr() {
		return descFr;
	}

	public void setDescFr(String desc_fr) {
		this.descFr = desc_fr;
	}

	
	//DESCING----------------------------------------------------------------

	@Column(name = "desc_ing", nullable = false, length=300)
	public String getDescIng() {
		return descIng;
	}

	public void setDescIng(String desc_ing) {
		this.descIng = desc_ing;
	}

	//PRECO----------------------------------------------------------------

	@Column(name = "preco", nullable = false)
	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	//QUANTIDADE------------------------------------------------------------

	@Column(name = "quantidade", nullable = false)
	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	
	//UnidadeMedidaEnum------------------------------------------------------
	@Enumerated(EnumType.STRING)
	@Column(name = "unidade_medida_enum", nullable = false)
	public UnidadeMedidaEnum getUnidadeMedidaEnum() {
		return unidadeMedidaEnum;
	}

	public void setUnidadeMedidaEnum(UnidadeMedidaEnum unidadeMedidaEnum) {
		this.unidadeMedidaEnum = unidadeMedidaEnum;
	}
	
	
	//DATA CADASTRO--------------------------------------------------------

	@Column(name = "data_cadastro",nullable = false)
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	//ID USER CADASTRO--------------------------------------------------------

	@Column(name = "id_user_cadastro",nullable = false)
	public long getIdUserCadastro() {
		return idUserCadastro;
	}

	public void setIdUserCadastro(long idUserCadastro) {
		this.idUserCadastro = idUserCadastro;
	}
	

	

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", activo=" + activo + ", ordem=" + ordem + ", pai=" + pai
				+ ", tipoItem=" + tipoItem + ", fotoPath=" + fotoPath + ", descPt=" + descPt + ", descFr=" + descFr
				+ ", descIng=" + descIng + ", preco=" + preco + ", quantidade=" + quantidade + ", unidadeMedidaEnum="
				+ unidadeMedidaEnum + ", dataCadastro=" + dataCadastro + ", idUserCadastro=" + idUserCadastro + "]";
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
