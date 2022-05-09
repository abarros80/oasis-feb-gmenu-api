package oasis.feb.gestaomenu.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_conjunto")
public class Conjunto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String nome;
	private boolean activo;
	private int ordem;
	private Conjunto pai;
	private TipoConjunto tipoConjunto;
	
	private List<Conjunto> subConjuntos;
	private List<Item> itens;
	
	//Dados especificos de um conj
	private String descPt;
	private String descFr;
	private String descIng;
	
	private String fotoPath;
	
	//Log cadastro
	private LocalDateTime dataCadastro;
	private Long  idUserCadastro;
	
	
	public Conjunto() {}
	
	
	


	public Conjunto(String nome, boolean activo, int ordem, Conjunto pai, TipoConjunto tipoConjunto, String desc_pt,
			String desc_fr, String desc_ing, String fotoPath, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.ordem = ordem;
		this.pai = pai;
		this.tipoConjunto = tipoConjunto;
		this.descPt = desc_pt;
		this.descFr = desc_fr;
		this.descIng = desc_ing;
		this.fotoPath = fotoPath;
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
		
		
		this.subConjuntos = new ArrayList<Conjunto>();
		this.itens = new ArrayList<Item>();
		
	}
	
	

	public Conjunto(String nome, boolean activo, int ordem, Conjunto pai, TipoConjunto tipoConjunto,
			List<Conjunto> subConjuntos, List<Item> itens, String desc_pt, String desc_fr, String desc_ing,
			String fotoPath, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.ordem = ordem;
		this.pai = pai;
		this.tipoConjunto = tipoConjunto;
		this.subConjuntos = subConjuntos;
		this.itens = itens;
		this.descPt = desc_pt;
		this.descFr = desc_fr;
		this.descIng = desc_ing;
		this.fotoPath = fotoPath;
		
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
	@Column(name = "nome", nullable = false, unique=true, length=100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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


	//ACTIVO----------------------------------------------------------------
	@NotNull(message = "Campo Activo obrigatorio")
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
	@ManyToOne
	@JoinColumn(name = "conjunto_id", nullable = true)
	public Conjunto getPai() {
		return pai;
	}

	public void setPai(Conjunto pai) {
		this.pai = pai;
	}



	//FILHOS----------------------------------------------------------------
	
	@OneToMany(mappedBy = "pai",cascade = CascadeType.ALL)
	public List<Conjunto> getSubConjuntos() {
		return subConjuntos;
	}

	public void setSubConjuntos(List<Conjunto> subConjuntos) {
		this.subConjuntos = subConjuntos;
	}
	
	public void addConjunto(Conjunto conjunto) {
		if(conjunto != null) {
			if(subConjuntos == null) {
				subConjuntos = new ArrayList<Conjunto>();
			}
			conjunto.setPai(this);
			subConjuntos.add(conjunto);	
		}
	}
	

	//TIPO CONJUNTO------------------------------------------------------------

	//@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_conjunto_id", referencedColumnName="id", nullable = false, updatable = false)

	public TipoConjunto getTipoConjunto() {
		return tipoConjunto;
	}

	public void setTipoConjunto(TipoConjunto tipoConjunto) {
		this.tipoConjunto = tipoConjunto;
	}


	//LIST ITENS------------------------------------------------------------

	@OneToMany(mappedBy = "pai",cascade = CascadeType.ALL)
	public List<Item> getItens() {
		return itens;
	}



	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item item) {
		if(item != null) {
			if(itens == null) {
				itens = new ArrayList<Item>();
			}
			item.setPai(this);
			itens.add(item);	
		}
	}
	
	

	//PATH FOTO------------------------------------------------------------

	@Column(name = "foto_path",nullable = true)
	public String getFotoPath() {
		return fotoPath;
	}

	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
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
		return "Conjunto [id=" + id + ", nome=" + nome + ", activo=" + activo + ", ordem=" + ordem + "]";
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
		Conjunto other = (Conjunto) obj;
		return id == other.id;
	}



}
