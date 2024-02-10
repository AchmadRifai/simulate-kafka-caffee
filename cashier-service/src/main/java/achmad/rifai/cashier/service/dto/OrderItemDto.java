package achmad.rifai.cashier.service.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderItemDto implements Serializable {

	private static final long serialVersionUID = 6268776340522966498L;

	private Integer quantity;
	private String idMenu;
}
