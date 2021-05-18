package cst438_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cst438_2.domain.CityInfo;
import cst438_2.service.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, Model model) {
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		model.addAttribute("cityInfo", cityInfo);
		return "cityWeather";
	}
	
	@PostMapping("/cities/reservation")
    public String createReservation(
            @RequestParam("city") String cityName, 
            @RequestParam("level") String level, 
            @RequestParam("email") String email, 
            Model model) {
        
        model.addAttribute("city", cityName);
        model.addAttribute("level", level);
        model.addAttribute("email", email);
        cityService.requestReservation(cityName, level, email);
        
        return "request_reservation";
    }

}
