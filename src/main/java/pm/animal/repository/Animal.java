package pm.animal.repository;

import java.util.Objects;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    Animal withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        return Objects.equals(this.name, other.name);
    }
}
