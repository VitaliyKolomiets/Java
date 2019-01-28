import java.util.Objects;

public  abstract class Telephone {
    private String model;

    Telephone(String model){
        this.model= model;
        System.out.println("Hello abstract class telephone");
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract void phone();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone)) return false;
        Telephone telephone = (Telephone) o;
        return Objects.equals(model, telephone.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "model='" + model + '\'' +
                '}';
    }
}
