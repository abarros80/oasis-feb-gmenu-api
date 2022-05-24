package oasis.feb.gestaomenu.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_tipo_item")
public class TipoItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private boolean activo;
	
	private List<Item> itens;
	
	//Log cadastro
	private LocalDateTime dataCadastro;
	private Long  idUserCadastro;
	
	public TipoItem() {}

	
	public TipoItem(String nome, boolean activo, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.itens = new ArrayList<Item>();
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
	}

	public TipoItem(String nome, boolean activo, List<Item> itens, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.itens = itens;
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	//ITENS----------------------------------------------------------------

	@OneToMany(mappedBy = "tipoItem",cascade = CascadeType.ALL)
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addProduto(Item item) {
		if(item != null) {
			if(itens == null) {
				itens = new ArrayList<Item>();
			}
			item.setTipoItem(this);
			itens.add(item);	
		}
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
		return "TipoItem [id=" + id + ", nome=" + nome + ", activo=" + activo + ", dataCadastro=" + dataCadastro
				+ ", idUserCadastro=" + idUserCadastro + "]";
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
		TipoItem other = (TipoItem) obj;
		return id == other.id;
	}
	
	
	

}

