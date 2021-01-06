package david.augusto.luan.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String password;
}