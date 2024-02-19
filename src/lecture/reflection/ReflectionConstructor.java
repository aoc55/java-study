package lecture.reflection;

import lecture.reflection.sample.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Reflection Constructor 관련 실습
 * Created by aoc55.soft@gmail.com
 */
public class ReflectionConstructor {

    public static void main(String[] args) {

        // Constructor Class 를 통해 Instance 생성 (1)
        try {
            Class<Person> clazz = Person.class;

            // .getConstructor() -> public 생성자만 반환
            Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);

            Person person = constructor.newInstance("A", 10);
            System.out.println("person = " + person);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }


        // Constructor Class 를 통해 Instance 생성 (2)
        try {
            Class<Person> clazz = Person.class;

            // .getDeclaredConstructor() -> public & private 생성자 모두 반환
            Constructor<Person> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // Accessible True 처리 -> "정말 특별한 경우에만 ..."

            Person person2 = constructor.newInstance();
            System.out.println("person2 = " + person2);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }


        // Constructor Class 를 통해 Instance 생성 (3)
        try {
            Person person3 = createInstanceWithArguments(Person.class, "CCC", 88);
            System.out.println("person3 = " + person3);

            Integer integer = createInstanceWithArguments(Integer.class, "10");
            System.out.println("Integer = " + integer);

        } catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Constructor Class 를 활용한 Dynamic 하게 Instance 생성하기
     */
    private static <T> T createInstanceWithArguments(Class<T> clazz, Object ... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for(Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if(constructor.getParameterTypes().length == args.length){
                constructor.setAccessible(true);
                Object instance = constructor.newInstance(args);
                return (T) instance;
            }
        }
        return null;
    }
}
