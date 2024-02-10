package achmad.rifai.kitchen.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -8570353830570132275L;

	@Id
	private UUID id;
	private String email;
	private String tableId;
	private BigDecimal total;
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Timestamp createdDate;
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items;
}
