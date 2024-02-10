package achmad.rifai.kitchen.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class KafkaMessage implements Serializable {

	private static final long serialVersionUID = -9003677209329560295L;

	private String id;
}
