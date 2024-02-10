package achmad.rifai.supplier.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MenuDto implements Serializable {

	private static final long serialVersionUID = -4241173811447795098L;

	@NotNull
	@NotEmpty
	@NotBlank
	private String name;
	@NotNull
	@NotEmpty
	@NotBlank
    private String category;
	@NotNull
	@Positive
    private BigDecimal price;
	@NotNull
	@Positive
    private Integer quantity;
}
