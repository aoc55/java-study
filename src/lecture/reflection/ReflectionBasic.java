package lecture.reflection;

import lecture.reflection.sample.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (설명)
 * Created by aoc55.soft@gmail.com
 */

public class ReflectionBasic {

    /**
     * Class<?> 를 얻는 방법
     */
    public static void getReflectionClass(){

        // 방법 1
        // - Object.getClass() 메소드 사용
        // - Primitive Type 의 경우 불가능
        Class<Object> objectClass = Object.class;
        Class<String> stringClass = String.class;
        Class<Integer> integerClass = Integer.class;

        Person instance = new Person("ABC", 20);
        Class<?> clazz = instance.getClass();

        // 방법 2
        // - Type이름.class
        // - Primitive Type도 가능
        Class<Integer> integerClass1 = int.class;
        Class<Double> doubleClass = double.class;


        // 방법 3
        // - Class.forName("클래스 경로")
        // - 컴파일 시점에 컴파일러가 알 수 없을 때 사용
        try {
            Class<?> stringClass2 = Class.forName("java.lang.String");
            Class<?> personClass = Class.forName("lecture.reflection.sample.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        getReflectionClass();
    }
}
