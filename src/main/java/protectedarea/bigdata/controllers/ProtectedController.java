package protectedarea.bigdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import protectedarea.bigdata.repository.ProtectedMongoRepository;
import protectedarea.bigdata.repository.ProtectedSearchRepository;

@Controller
public class ProtectedController {

	@Autowired
	ProtectedMongoRepository protectedRepository;
	
	@Autowired
	ProtectedSearchRepository protectedSearchRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("protectedList", protectedRepository.findAll());
		return "home";
	}
	
	
	/*@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Protected car) {
		protectedRepository.save(car);
		return "redirect:home";
	}*/
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("protectedList", protectedSearchRepository.searchProtected(search));
		model.addAttribute("search", search);
		return "home";
	}
	
}