package cst438_2;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import cst438_2.controller.CityRestController;
import cst438_2.domain.City;
import cst438_2.domain.CityInfo;
import cst438_2.domain.CityRepository;
import cst438_2.domain.Country;
import cst438_2.domain.TimeAndTemp;
import cst438_2.service.CityService;

@WebMvcTest(CityRestController.class)
public class CityRestControllerTest {	
	@MockBean
	private CityService cityService;
	
	@MockBean
	private CityRepository cityRepository;
	
	@InjectMocks
	private CityRestController cityRestController;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUpEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetWeather() throws Exception {
		//Setup - Arrange
		TimeAndTemp timeAndTemp = new TimeAndTemp(7.0, "Face", 3);
		
		CityInfo cityInfo = new CityInfo(1,"TestCity","Test Country","TEST","DistrictTest", 
				100000,timeAndTemp);
		
		Mockito.when(cityService.getCityInfo("TestCity")).thenReturn(cityInfo);
		
		Country country = new Country("Test Country","TST");
		City city = new City(1,"TestCity","DistrictTest", 100000, country);
		List<City> cities = new ArrayList<City>();
		cities.add(city);
		
		Mockito.when(cityRepository.findByName("TestCity")).thenReturn(cities);
		
		
		
		//Call - Act
		ResponseEntity<CityInfo> response = cityRestController.getWeather("TestCity");
		
		//Check - Assert
		assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getBody()).isEqualTo(cityInfo);
		
		

		//GETMAPPING NOT TESTED
		//MockHttpServletResponse response = mvc.perform(get("/city/TestCity")).andReturn().getResponse();
	}
}
