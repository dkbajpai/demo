package in.nic.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nic.demo.dao.ProcessedDataDao;
import in.nic.demo.dao.RawDataDao;
import in.nic.demo.entities.ProcessedData;
import in.nic.demo.entities.RawData;

@Service
public class BasicServices {

	@Autowired
	private RawDataDao rawDataDao;
	@Autowired
	private ProcessedDataDao processedDataDao;

	public String addData(String data) {
		RawData rawData = new RawData();
		rawData.setData(data);
		rawData.setProcessed(false);
		rawDataDao.save(rawData);
		return "Success";
	}

	public String processData() throws JsonMappingException, JsonProcessingException {

		RawData rawData = rawDataDao.findTop1ByProcessed();

		if (rawData == null) {
			return null;
		}

		JsonNode node = new ObjectMapper().readValue(rawData.getData(), JsonNode.class);
		JsonNode data = node.get("data");
		data.forEach(element -> {
			int oid = element.get("oid").asInt();
			String name = element.get("name").asText();
			ProcessedData processedData = new ProcessedData();
			processedData.setOid(oid);
			processedData.setName(name);
			processedDataDao.save(processedData);
		});
		rawData.setProcessed(true);
		rawDataDao.save(rawData);

		return null;
	}

}
