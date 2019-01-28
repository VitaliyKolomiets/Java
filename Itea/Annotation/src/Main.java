import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //Class clazz=Cat.class;
        Cat cat= new Cat("susleg");
        Class clazz= cat.getClass();
        /*Cat cat= new Cat("susleg");
        */
        /*int mod =clazz.getModifiers();
        if (Modifier.isAbstract(mod)){
            System.out.println("class is public");
        }
        System.out.println(clazz.getSuperclass());


        Class[] interfaces = clazz.getInterfaces();
        for(Class interfyce: interfaces){
            System.out.println(interfyce.getName());
        }
        Field[] fields=clazz.getFields();
        for(Field field: fields){
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        Field f=clazz.getField("color");*/
        //String color= (String)f.get(cat);
        //System.out.println(color);



       /* Method[] ca =clazz.getMethods();
        for(Method method: ca){
            System.out.println(method.getName());
            for (Class parametrs : method.getParameterTypes()){
                System.out.println(parametrs.getName());
            }
        }*/
    /*    Method d=clazz.getMethod("setSomething");
        String idf =d.get(cat);*/
/*    Class cc = Class.forName("Cat");
    Cat cat1=(Cat)cc.newInstance();
        System.out.println(cat1.color);



        Field f2=clazz.getDeclaredField("skin");
        f2.setAccessible(true);
        String skin= (String)f2.get(cat);
        f2.set(cat,"wood");
        skin= (String)f2.get(cat);
         System.out.println(skin);


         Method method = clazz.getDeclaredMethod("setSomething");
         method.setAccessible(true);
         method.invoke(cat);*/

        Method method1 = clazz.getDeclaredMethod("getVoice");
        method1.setAccessible(true);
        method1.invoke(cat);

        Method method = clazz.getMethod("setSomething", String.class, int.class);
        method.invoke(cat,"dsnf",3);

        System.out.println(method.getAnnotation(MyAnno.class).str());
        System.out.println(method.getAnnotation(MyAnno.class).value());




    }





}
