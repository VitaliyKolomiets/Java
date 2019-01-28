public class Dog {
    String name;
    String age;
    public Dog(){};

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public String getAge() {
        return age;
    }
}
