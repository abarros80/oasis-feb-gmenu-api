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
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "tbl_tipo_conjunto")
public class TipoConjunto implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	private Long id;
	private String nome;
	private boolean activo;
	
	private List<Conjunto> conjuntos;
	
	//Log cadastro
	private LocalDateTime dataCadastro;
	private Long  idUserCadastro;
	
	public TipoConjunto() {}

	
	public TipoConjunto(String nome, boolean activo, List<Conjunto> conjuntos, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.conjuntos = conjuntos;
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
	}

	
	public TipoConjunto(String nome, boolean activo, LocalDateTime dataCadastro, Long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		
		this.conjuntos = new ArrayList<Conjunto>();
		
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
	@NotNull(message = "Campo Activo obrigatorio")
	@Column(name = "activo", nullable = false, columnDefinition="bit(1) default 1")
	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	//CONJUNTOS----------------------------------------------------------------
	@OneToMany(mappedBy = "tipoConjunto", targetEntity = Conjunto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(List<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}
	
	public void addConjunto(Conjunto conjunto) {
		if(conjunto != null) {
			if(conjuntos == null) {
				conjuntos = new ArrayList<Conjunto>();
			}
			conjunto.setTipoConjunto(this);
			conjuntos.add(conjunto);	
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
		TipoConjunto other = (TipoConjunto) obj;
		return id == other.id;
	}


	@Override
	public String toString() {
		return "TipoConjunto [id=" + id + ", nome=" + nome + ", activo=" + activo + "]";
	}


}
