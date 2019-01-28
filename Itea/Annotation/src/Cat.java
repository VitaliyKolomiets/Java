public class Cat extends Animal implements AnimalWeight{

    public String color="white";
    private String skin="white";
    public Cat(){super("");}

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", skin='" + skin + '\'' +
                '}';
    }

    public Cat(String name) {
        super(name);
    }
    @MyAnno(value=6613)
    public void setSomething(String some, int another) {
        System.out.println("set"+some+" "+another);
    }

    @Override
    public void getVoice() {
        System.out.println("miu");
    }

    @Override
    public double getWeight() {
        return 10.5;
    }
}
