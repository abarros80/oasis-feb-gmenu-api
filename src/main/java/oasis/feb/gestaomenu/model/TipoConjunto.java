package oasis.feb.gestaomenu.model;

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


@Entity
@Table(name = "tbl_tipo_conjunto")
public class TipoConjunto {	
	
	private long id;
	private String nome;
	private boolean activo;
	
	private List<Conjunto> conjuntos;
	
	//Log cadastro
	private LocalDateTime dataCadastro;
	private long  idUserCadastro;
	
	public TipoConjunto() {}

	
	public TipoConjunto(String nome, boolean activo, List<Conjunto> conjuntos, LocalDateTime dataCadastro, long  idUserCadastro) {
		super();
		this.nome = nome;
		this.activo = activo;
		this.conjuntos = conjuntos;
		
		this.dataCadastro = dataCadastro;
		this.idUserCadastro = idUserCadastro;
	}

	
	public TipoConjunto(String nome, boolean activo, LocalDateTime dataCadastro, long  idUserCadastro) {
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
	

	//CONJUNTOS----------------------------------------------------------------

	@OneToMany(mappedBy = "tipoConjunto",cascade = CascadeType.ALL)
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
		return "TipoConjunto [id=" + id + ", nome=" + nome + ", activo=" + activo + ", conjuntos=" + conjuntos
				+ ", dataCadastro=" + dataCadastro + ", idUserCadastro=" + idUserCadastro + "]";
	}



}
