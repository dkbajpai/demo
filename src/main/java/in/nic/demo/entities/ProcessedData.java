package in.nic.demo.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessedData {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	private int oid;
	private String name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
}
