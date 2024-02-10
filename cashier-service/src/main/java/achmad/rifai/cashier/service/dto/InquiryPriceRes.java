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
public class InquiryPriceRes implements Serializable {

	private static final long serialVersionUID = 1953419134752730532L;

	private String totalPrice;
}
