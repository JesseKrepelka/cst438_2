package cst438_2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438_2.domain.*;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private WeatherService weatherService;
	
	public CityInfo getCityInfo(String cityName) {
		List<City> cities = cityRepository.findByName(cityName);
		if(cities.size()==0) {
			return null;
					//new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		} else {
			//If many take first
			City city=cities.get(0);
			
			return new CityInfo(city.getId(), city.getName(), city.getCountry().getName(), 
					city.getCountry().getCode(), city.getDistrict(),city.getPopulation(), 
					weatherService.getTimeAndTemp(cityName));
		}
	}
}
