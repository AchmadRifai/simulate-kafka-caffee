package achmad.rifai.cashier.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = -5402982243852993241L;
	private String id;
    private String name;
    private List<MenuDto> menus;
}
