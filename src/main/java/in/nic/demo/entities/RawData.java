package in.nic.demo.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
public class RawData {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	@Column(columnDefinition = "TEXT")
	private String data;
	@Column(nullable = true)
	private boolean processed = false;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

}
