import java.util.Set;

public class Actor implements Comparable<Actor> {

    private String name;
    private Set<String>  listFilm;
    private int year;

    public Actor(String name ,Set<String>  listFilm, int year) {
        this.name = name;
        this.listFilm = listFilm;
        this.year=year;
    }


    public Set<String> getListFilm() {
       return listFilm;
    }

    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", listFilm=" +listFilm+
                '}';
    }

    @Override
    public int compareTo(Actor o) {
        return name.compareTo(o.getName());
    }
}
