package oasis.feb.gestaomenu.model.dto;

import java.io.Serializable;

import oasis.feb.gestaomenu.model.Conjunto;
import oasis.feb.gestaomenu.model.TipoConjunto;

public class ConjuntoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private long id;
	private String nome;
	private boolean activo;
	private int ordem;
	private Conjunto pai;
	private TipoConjunto tipoConjunto;
	
	//Dados especificos de um conj
	private String descPt;
	private String descFr;
	private String descIng;
	
	private String fotoPath;
	
	//Log cadastro
	private long  idUserCadastro;
	
	

	public ConjuntoDTO() {
		super();
	}



	public ConjuntoDTO(Conjunto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.activo = obj.getActivo();
		this.ordem = obj.getOrdem();
		this.pai = obj.getPai();
		this.tipoConjunto = obj.getTipoConjunto();
		this.descPt = obj.getDescPt();
		this.descFr = obj.getDescFr();
		this.descIng = obj.getDescIng();
		this.fotoPath = obj.getFotoPath();
		this.idUserCadastro = obj.getIdUserCadastro();
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public boolean getActivo() {
		return activo;
	}



	public void setActivo(boolean activo) {
		this.activo = activo;
	}



	public int getOrdem() {
		return ordem;
	}



	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}



	public Conjunto getPai() {
		return pai;
	}



	public void setPai(Conjunto pai) {
		this.pai = pai;
	}



	public TipoConjunto getTipoConjunto() {
		return tipoConjunto;
	}



	public void setTipoConjunto(TipoConjunto tipoConjunto) {
		this.tipoConjunto = tipoConjunto;
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



	public String getFotoPath() {
		return fotoPath;
	}



	public void setFotoPath(String fotoPath) {
		this.fotoPath = fotoPath;
	}



	public long getIdUserCadastro() {
		return idUserCadastro;
	}



	public void setIdUserCadastro(long idUserCadastro) {
		this.idUserCadastro = idUserCadastro;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
