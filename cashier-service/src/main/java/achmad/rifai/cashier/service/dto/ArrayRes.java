package achmad.rifai.cashier.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ArrayRes<T> implements Serializable {
    private static final long serialVersionUID = 4106157244248412483L;
	private transient List<T> datas;
}
