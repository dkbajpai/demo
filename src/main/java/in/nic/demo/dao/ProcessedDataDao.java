package in.nic.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nic.demo.entities.ProcessedData;

public interface ProcessedDataDao extends JpaRepository<ProcessedData, Long> {

}
