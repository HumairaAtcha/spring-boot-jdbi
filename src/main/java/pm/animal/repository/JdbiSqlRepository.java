package pm.animal.repository;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbiSqlRepository {

    @SqlQuery("SELECT * FROM animals")
    @Mapper(AnimalMapper.class)
    List<Animal> getAll();
}
