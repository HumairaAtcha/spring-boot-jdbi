package pm.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pm.animal.repository.Animal;
import pm.animal.repository.JdbiSqlRepository;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private JdbiSqlRepository repository;

    @Autowired
    public AnimalController(JdbiSqlRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/all")
    public List<Animal> getAllAnimals() {
        return repository.getAll();
    }
}
