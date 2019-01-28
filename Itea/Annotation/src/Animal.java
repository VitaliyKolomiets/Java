public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void getVoice();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
