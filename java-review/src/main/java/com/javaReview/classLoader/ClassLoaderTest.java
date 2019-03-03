package com.javaReview.classLoader;

/**
 * Created by jiangmingli on 2017/10/26.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Employee");
            System.out.println(clazz.getClassLoader()
                    + "\n" +  clazz.getSimpleName()
                    + "\n" +  clazz.getDeclaredMethods());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
