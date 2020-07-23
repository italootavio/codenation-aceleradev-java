package challenge;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter @Setter
@Entity
@Table(name = "scripts")
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "actor")
	private String actor;

	@Column(name = "detail")
	private String quote;

}
