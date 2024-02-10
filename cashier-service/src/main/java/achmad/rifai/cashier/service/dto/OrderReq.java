package achmad.rifai.cashier.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class OrderReq implements Serializable {

	private static final long serialVersionUID = 3660975767456492166L;

	private List<OrderItemDto> orders;
	private String email;
	private String tableId;
}