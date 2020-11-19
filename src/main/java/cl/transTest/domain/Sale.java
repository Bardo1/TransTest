package cl.transTest.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 * Sale - Clase dominio para una venta
 *
 * @author Walter Munoz
 * @since 1.0
 * @version 1.0 version inicial
 */
@Entity
@Table(name="TBL_SALE")
public class Sale {
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="number")
    private Integer number;
	
	@Column(name="description")
    private String description;
    
    @Column(name="quantity")
    private Integer quantity;
    
	@Column(name="value")
	private Integer value;
    
	@Column(name="date")
	@Type(type="date")
	private Date date;

	public Sale() {
	}
		
	public Sale(Integer number, String description, Integer quantity, Integer value, Date date) {
		super();

		this.number = number;
		this.description = description;
		this.quantity = quantity;
		this.value = value;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", number=" + number + ", description=" + description + ", quantity=" + quantity
				+ ", value=" + value + ", date=" + date + "]";
	}

     
}

