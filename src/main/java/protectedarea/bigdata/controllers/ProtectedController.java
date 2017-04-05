package protectedarea.bigdata.controllers;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import protectedarea.bigdata.repository.ProtectedMongoRepository;
import protectedarea.bigdata.repository.ProtectedSearchRepository;

@Controller
public class ProtectedController {

	@Autowired
	ProtectedMongoRepository protectedRepository;
	
	@Autowired
	ProtectedSearchRepository protectedSearchRepository;
	
	 @Autowired
	  private MongoTemplate mongoTemplate;
	
	 @RequestMapping("/index")
		public String index(Model model) {
			return "index";
		}
	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@Scheduled(fixedRate = 10000)
	@RequestMapping(value="#", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public void saveData() {
	   final String uri ="http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=ded2287ef7a2d51872d4db98e37183d6";
	   // final String uri="https://vpal3@uwo.ca:clandestine98@twcservice.mybluemix.net:443/api/weather/v1/location/97229%3A4%3AUS/forecast/hourly/48hour.json?units=m&language=en-US";
	   
	   //final String uri="https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets?stationid=COOP:310090&stationid=COOP:310184&stationid=COOP:310212/JnWxbrjzqgDyCvOrJqVgBvBlFptgAIbH";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    
	    mongoTemplate.insert(result, "vikram-protected");   
		
	}
	
	
	/*@Scheduled(fixedRate=100000)
	
	public void scheduleCrawlerJob() throws MalformedURLException {
	        Iterable<ProtectedMongoRepository> links = repo.findAll();
	        ProtectedMongoRepository link = protectedRepository.save(new ProtectedMongoRepository(new URL("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=ded2287ef7a2d51872d4db98e37183d6")));
	}
	  */   
	
		    
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("protectedList", protectedSearchRepository.searchProtected(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}