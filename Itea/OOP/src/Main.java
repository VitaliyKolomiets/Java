public class Main {
    public static void main(String[] args) {
       Smartphone smartphone= new Smartphone("samsung", "blue");
       Smartphone smartphone1= new Smartphone("samsung", "blue");
       Smartphone smartphone2= new Smartphone("lg", "red");
       smartphone.phone();
       smartphone1.phone();
       System.out.println(smartphone.equals(smartphone1));
       System.out.println(smartphone.toString());
       System.out.println(smartphone1.toString());
    }
}
