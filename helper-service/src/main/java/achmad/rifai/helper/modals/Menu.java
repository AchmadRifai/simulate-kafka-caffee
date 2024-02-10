package achmad.rifai.helper.modals;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Document(indexName = "menu")
@NoArgsConstructor
public class Menu implements Serializable {

	private static final long serialVersionUID = -726060292367683254L;

	@Id
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
