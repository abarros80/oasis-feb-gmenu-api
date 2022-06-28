package oasis.feb.gestaomenu.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class Log {
	
	//Log cadastro
  	private LocalDateTime dataCriacao;
  	private LocalDateTime dataAlteracao;
  	private Long  idUserCriacao;
  	private Long  idUserAlteracao;
  	
  //DATA CRIACAO--------------------------------------------------------	
  	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  	//@NotNull(message = "Campo DATA CRIACAO obrigatorio")
  	@Column(name = "data_criacao")
  	//@CreationTimestamp
  	public LocalDateTime getDataCriacao() {
  		return dataCriacao;
  	}

  	public void setDataCriacao(LocalDateTime dataCriacao) {
  		this.dataCriacao = dataCriacao;
  	}

  	//DATA ALTERACAO--------------------------------------------------------
  	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  	//@NotNull(message = "Campo DATA ALTERACAO obrigatorio")
  	@Column(name = "data_alteracao")
  	//@UpdateTimestamp
  	public LocalDateTime getDataAlteracao() {
  		return dataAlteracao;
  	}

  	public void setDataAlteracao(LocalDateTime dataAlteracao) {
  		this.dataAlteracao = dataAlteracao;
  	}

  	//ID USER CADASTRO--------------------------------------------------------
  	@NotNull(message = "Campo USER CRIACAO obrigatorio")
  	@Column(name = "id_user_criacao",nullable = false)
  	public Long getIdUserCriacao() {
  		return idUserCriacao;
  	}

  	public void setIdUserCriacao(Long idUserCriacao) {
  		this.idUserCriacao = idUserCriacao;
  	}

  	//ID USER ALTERACAO--------------------------------------------------------
  	@NotNull(message = "Campo USER ALTERACAO obrigatorio")
  	@Column(name = "id_user_alteracao",nullable = false)
  	public Long getIdUserAlteracao() {
  		return idUserAlteracao;
  	}

  	public void setIdUserAlteracao(Long idUserAlteracao) {
  		this.idUserAlteracao = idUserAlteracao;
  	}
  	
  	
}
