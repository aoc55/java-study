package lecture.reflection;

import lecture.reflection.sample.Category;
import lecture.reflection.sample.Movie;

import java.lang.reflect.Field;

/**
 * Reflection Field 관련 실습
 * Created by aoc55.soft@gmail.com
 */

public class ReflectionField {

    public static void main(String[] args) {

        Movie movie1 = new Movie("movie1", 2012, true, Category.ROMANCE, 10000);
        
        // [ Field Class 조회 1 ]
        // - getFigetDeclaredFields() : 접근 제어자 상관없이 조회
        for(Field field : movie1.getClass().getDeclaredFields()) {
            System.out.println("field.getName() = " + field.getName());
            System.out.println("field.getType() = " + field.getType());
            System.out.println();
        }

        // [ Field Class 조회 2 ]
        // - getFields() : public 만 조회
        for(Field field : movie1.getClass().getFields()) {
            System.out.println("field.getName() = " + field.getName());
            System.out.println("field.getType() = " + field.getType());
            System.out.println();
        }

        // [ Field Class 조회 3 & 값 추출 ]
        try {
            Field actualPriceField = Movie.class.getDeclaredField("actualPrice");
            actualPriceField.setAccessible(true);
            double actualPrice = (double) actualPriceField.get(movie1); // 값 추출
            System.out.println("actualPrice = " + actualPrice);
            System.out.println();
        } catch (NoSuchFieldException | IllegalAccessException e) { e.printStackTrace(); }

        // [ Static Field 값 추출 ]
        try {
            Field countryField = Movie.class.getDeclaredField("COUNTRY");
            String country = (String) countryField.get(null); // Static 의 경우 Null 설정
            System.out.println("country = " + country);
            System.out.println();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // [ Synthetic Field 조회 ]
        for(Field field : Movie.MovieStats.class.getDeclaredFields()) {
            if(field.isSynthetic()){
                System.out.println("field.getName() = " + field.getName());
                System.out.println("field.isSynthetic() = " + field.isSynthetic());
            }
        }
        
    }

}
