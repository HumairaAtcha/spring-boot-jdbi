package pm.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    public AnimalController() {
    }

    @RequestMapping("/all")
    public String getAllAnimals() {
        return "All animals coming shortly\n";
    }
}
