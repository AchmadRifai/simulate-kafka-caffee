package achmad.rifai.kitchen.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table
public class Category implements Serializable {

	private static final long serialVersionUID = 3086441281846949013L;

	@Id
	private UUID id;
	private String name;
	@OneToMany(mappedBy = "category")
	private List<Menu> menus;
}
