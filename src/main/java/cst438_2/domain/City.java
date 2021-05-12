package cst438_2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class City {
	
	@Id
	private int id;
	private String name;
	private String district;
	private int population;
	
	@Transient
	TimeAndTemp TimeAndTempCity;

	@ManyToOne
	@JoinColumn(name="countrycode",referencedColumnName="code")
	private Country country;
	
	public City() {
		
	}
	
	public City(int id, String name, String district, int population, Country country) {
		this.id = id;
		this.name = name;
		this.district = district;
		this.population = population;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public TimeAndTemp getTimeAndTempCity() {
		return TimeAndTempCity;
	}

	public void setTimeAndTempCity(TimeAndTemp timeAndTempCity) {
		TimeAndTempCity = timeAndTempCity;
	}
}
