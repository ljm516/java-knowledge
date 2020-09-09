package top.ljming.javaindepth.designpatterns.geeklesson.decorator;

import java.io.*;

/**
 * 装饰器模式.
 *
 * 装饰器类和原始类继承同样的父类，可以对原始类"嵌套"多个装饰器类。
 * 装饰器类是对功能的增强，这也是装饰器模式应用场景的一个重要特定。
 *
 * 代理类附加的是和原始类无关的功能，装饰器模式附加的是和原始类相关的功能。
 *
 * @author ljming
 */
public class DecoratorApplication {

    public static void main(String[] args) {
        Programmer programmer = new JavaProgrammer();
        KnowAlgorithmProgrammer algorithmProgrammer = new KnowAlgorithmProgrammer(programmer);
        KnowDesignPatternProgrammer designPatternProgrammer = new KnowDesignPatternProgrammer(programmer);

        algorithmProgrammer.ability();
        designPatternProgrammer.ability();

    }
}
