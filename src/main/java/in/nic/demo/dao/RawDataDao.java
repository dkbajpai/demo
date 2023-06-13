package in.nic.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nic.demo.entities.RawData;

public interface RawDataDao extends JpaRepository<RawData, Long> {

	@Query(nativeQuery = true, value =  "SELECT * FROM raw_data rd WHERE rd.processed IS FALSE LIMIT 1")
	RawData findTop1ByProcessed();

}
