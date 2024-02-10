package achmad.rifai.kitchen.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -4309431209104460265L;

	@Id
	private UUID id;
	private Integer quantity;
	@ManyToOne(optional = false)
	@JoinColumn(name = "menu_id", columnDefinition = "uuid")
	private Menu menu;
	@ManyToOne(optional = false)
	@JoinColumn(name = "order_id", columnDefinition = "uuid")
	private Order order;
	private BigDecimal subtotal;
}
