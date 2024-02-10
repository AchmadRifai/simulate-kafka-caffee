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
public class InquiryPriceReq implements Serializable {

	private static final long serialVersionUID = -7271494113552017267L;

	private List<OrderItemDto> items;
}
