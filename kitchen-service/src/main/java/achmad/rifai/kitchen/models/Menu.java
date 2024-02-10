package achmad.rifai.kitchen.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table
public class Menu implements Serializable {

	private static final long serialVersionUID = 4089876581967971000L;

	@Id
	private UUID id;
	private String name;
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id", columnDefinition = "uuid")
	private Category category;
	private Integer stock;
	private BigDecimal price;
	@OneToMany(mappedBy = "menu")
	private List<OrderItem> orders;
	@OneToMany(mappedBy = "menu")
	private List<SuppliedItem> supplieds;
}
