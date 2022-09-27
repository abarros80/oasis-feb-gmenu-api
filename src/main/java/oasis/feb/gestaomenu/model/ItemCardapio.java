package oasis.feb.gestaomenu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_item_cardapio", uniqueConstraints = {
        @UniqueConstraint(
        		name = "uc_item_cardapio",
        		columnNames = {"item_id", "cardapio_id"})
})
public class ItemCardapio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int ordem;
	
	private Item item;
	private Cardapio cardapio;
	
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
	
	
	//ITEM--------------------------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "item_id", nullable = false)
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	//CARDAPIO--------------------------------------------------------------
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cardapio_id", nullable = false)
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

}
