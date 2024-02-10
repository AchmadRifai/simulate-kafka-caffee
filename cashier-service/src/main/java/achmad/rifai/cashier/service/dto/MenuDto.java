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
public class MenuDto implements Serializable {
    private static final long serialVersionUID = -5005344677145726452L;
	private String id;
    private String name;
    private String category;
    private String price;
}
