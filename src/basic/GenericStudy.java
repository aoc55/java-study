package basic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericStudy {

    static <T> T testMethod(T value, T value2){
        return value2;
    }

    static <T> T testMethod2(T value){
        return value;
    }

    static void testMethod3(List<String> stringList){
    }

    public static void main(String[] args) {

        // [ Type Inference ]
        // - T : String 와, T: ArrayList<String>의 공통 부모인 Serializable 로 추론
        Serializable result = testMethod("HI", new ArrayList<String>());


        // [ Type Inference 2 ]
        // - Type Inference 통해서 'Type Witness' 생략 가능
        Integer integer1 = GenericStudy.<Integer>testMethod2(Integer.valueOf(10));
        Integer integer2 = GenericStudy.testMethod2(Integer.valueOf(10));
        String myString1 = GenericStudy.<String>testMethod2("HELLO");
        String myString2 = GenericStudy.testMethod2("HELLO");


        // [ Type Inference 3 ]
        // - Generic 클래스 생성자 호출 시 Type Argument -> <> 로 대체 가능
        // - public class ArrayList<E> extends AbstractList<E> implements ...
        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<String> strings2 = new ArrayList<>();


        // [ Target Type ]
        // - 표현식 위치(컨텍스트)에 따라서 Type 을 추론
        try {
            // List<String> 추론
            List<String> myStrList = Collections.emptyList();
            myStrList.add("hi");
        } catch (UnsupportedOperationException e) {
            // Immutable
        }

        try {
            // List<Integer> 추론
            List<Integer> myIntList = Collections.emptyList();
            myIntList.add(123);
        } catch (UnsupportedOperationException e) {
            // Immutable
        }

        // - Type Witness 사용해서 명시적으로 선언
        List<String> myStrList2 = Collections.<String>emptyList();


        // [ Target Type 2 ]
        // - java 8 이후 지원
        // - Method의 Parameter 타입도 함께 체크해서 추론함
        testMethod3(Collections.emptyList()); // method parameter Type -> List<String>

    }

}
