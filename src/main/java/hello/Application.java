package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
public class Application {

    @Autowired
    private CityService cityService;

    @GetMapping("/show")
    public String findCities(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "show";
    }

    @GetMapping("/signup")
    public String showSignUpForm(City city) {
        return "add";
    }

    @PostMapping("/addcity")
    public String addUser(City city, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }

        cityService.save(city);
        model.addAttribute("cities", cityService.findAll());
        return "redirect:/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") long id, Model model) {
        City city = cityService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id:" + id));
        cityService.delete(city);
        model.addAttribute("cities", cityService.findAll());
        return "redirect:/show";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}