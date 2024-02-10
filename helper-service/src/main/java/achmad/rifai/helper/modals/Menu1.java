package achmad.rifai.helper.modals;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Menu1 implements Serializable {

	private static final long serialVersionUID = -418511680870474521L;

	@Field(type = FieldType.Text)
	private String id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Text)
	private String category;
	@Field(type = FieldType.Text)
	private String price;
	@Field(type = FieldType.Integer)
	private Integer stock;
}
