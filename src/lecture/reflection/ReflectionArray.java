package lecture.reflection;

import java.lang.reflect.Array;

/**
 * Reflection Array 관련 실습
 * Created by aoc55.soft@gmail.com
 */

public class ReflectionArray {

    public static void main(String[] args) {

        String[] myStrArr = {"1", "2", "3"};

        // [ Array 타입 여부 판별 ]
        System.out.println("myStrArr.getClass().isArray() = " + myStrArr.getClass().isArray());

        // [ Array 배열 Type 확인 ]
        System.out.println("myStrArr.getClass().getComponentType() = " + myStrArr.getClass().getComponentType());

        // [ Array Helper Class ]
        // - Array 내 값 획득 등
        String firstValue = (String) Array.get(myStrArr, 0);
        System.out.println("firstValue = " + firstValue);

        int length = Array.getLength(myStrArr);
        System.out.println("length = " + length);

    }

}
