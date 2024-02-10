package achmad.rifai.cashier.service.modals;

import java.io.Serializable;
import java.util.List;

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
@Document(indexName = "category")
@NoArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = 3595199446654911265L;

	@Id
	private String id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Menu1> menus;
}
