/*
 * Copyright (C) 2018 www.missfresh.cn All rights reserved.
 *
 * Created by lijm on 2019/4/14.
 */

package top.ljming.leaning.inDepth.jvm;

import org.junit.Test;

/**
 * String.intern() 测试.
 *
 * @author lijm
 */
public class StringIntern {

    @Test
    public void test() {
        String s1 = new StringBuilder("hello").append(" world").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
