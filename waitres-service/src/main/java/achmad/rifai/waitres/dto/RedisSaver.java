package achmad.rifai.waitres.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RedisSaver implements Serializable {

	private static final long serialVersionUID = -2436719334958799993L;

	private String id;
    private Map<String, Object> redisLocal;
}
