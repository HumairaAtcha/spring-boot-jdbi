package pm.animal.repository;

public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    Animal withName(String name) {
        this.name = name;
        return this;
    }
}
