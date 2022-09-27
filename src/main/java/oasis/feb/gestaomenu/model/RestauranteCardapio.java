package oasis.feb.gestaomenu.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_restaurante_cardapio", uniqueConstraints = {
        @UniqueConstraint(
        		name = "uc_restaurante_cardapio",
        		columnNames = {"restaurante_id", "cardapio_id"})
})
public class RestauranteCardapio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private int ordem;
	
	private Restaurante restaurante;
	private Cardapio cardapio;

	//ID--------------------------------------------------------------
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	//ORDEM----------------------------------------------------------------
	@NotNull(message = "Campo ORDEM obrigatorio")
	@Digits(integer = 3, fraction = 0,message = "Campo ORDEM obrigatorio")
	@Column(name = "ordem", nullable = false)
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	//RESTAURANTE--------------------------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "restaurante_id", nullable = false)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Restaurante getRestaurante() {
		return restaurante;
	}
	
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	//CARDAPIO--------------------------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cardapio_id", nullable = false)
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	

}
