package achmad.rifai.supplier.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class SupplyReq implements Serializable {

	private static final long serialVersionUID = 5800912566375859482L;

	@NotNull
	@NotEmpty
	@NotBlank
	@Email
	private String email;
	@NotNull
	@NotEmpty
	private List<MenuDto> items;
}
