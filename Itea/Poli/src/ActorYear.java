import java.util.Comparator;

public class ActorYear implements Comparator<Actor> {
    @Override
    public int compare(Actor o1, Actor o2) {

        if (o1.getYear() < o2.getYear()) return -1;
        if (o1.getYear() > o2.getYear()) return 1;
        else return 0;
    }
}
