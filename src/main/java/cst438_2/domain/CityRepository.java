package cst438_2.domain;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByName(String name);
}
