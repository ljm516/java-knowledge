package top.ljming.springmvc.learn.spring.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射.
 *
 * @author lijm
 */
public class RelfectLearn {

    public static Class getClassByForName() {
        try {
            return Class.forName("top.ljming.springmvc.learn.spring.ioc.ClassA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class getClassByClass() {
        return ClassA.class;
    }

    public Class getClassByGetClass() {
        ClassA ca = new ClassA();
        return ca.getClass();
    }

    public static void main(String[] args) {
        Class clazz = getClassByForName();
        try {
            if (null != clazz) {
                ClassA ca = (ClassA) clazz.newInstance();
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getObject() {
        Class clazz = getClassByForName();
        if (null != clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Object getObjectByConstructor() {
        Class clazz = getClassByForName();
        if (null != clazz) {
            try {
                Constructor constructor = clazz.getConstructor(ClassA.class);
                return constructor.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
