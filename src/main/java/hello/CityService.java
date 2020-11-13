package hello;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        var cities = (List<City>) repository.findAll();
        return cities;
    }
}