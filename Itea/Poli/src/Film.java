import java.util.Set;

public class Film implements Comparable<Film>{
    private String name;
    private Set<String> listActor;

    public Set<String> getListActor() {
        return listActor;
    }

    public Film(String name, Set<String> listActor) {
        this.name = name;
        this.listActor = listActor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", listActor=" + listActor +
                '}';
    }

    @Override
    public int compareTo(Film o) {
        return name.compareTo(o.getName());
    }
}
