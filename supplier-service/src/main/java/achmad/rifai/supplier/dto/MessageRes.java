package achmad.rifai.supplier.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class MessageRes implements Serializable {

	private static final long serialVersionUID = -4336695054366647604L;

	private String message;
}
