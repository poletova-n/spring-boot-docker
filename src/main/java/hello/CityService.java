package hello;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    public Optional<City> findById(long id) {
        return repository.findById(id);
    }

    public void delete(City city) {
        repository.delete(city);
    }

    public void save(City city) {
        repository.save(city);
    }
}