public class Smartphone extends Telephone {
    public String color;

    Smartphone(String model) {
        super(model);
    }
    Smartphone(String model,String color){
        super(model);
        this.color=color;

    }

    @Override
    public void phone() {
        System.out.println(getModel());
    }

    @Override
    public String toString() {
        return "Smartphone{" + getModel()+
                " color='" + color + '\'' +
                '}';
    }
}
