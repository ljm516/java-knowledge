/*
 * Copyright (C) 2018 www.missfresh.cn All rights reserved.
 *
 * Created by lijm@missfresh.cn on 2019/4/4.
 */

package top.ljming.springmvc.learn.test.rss;

import org.junit.Test;
import top.ljming.springmvc.learn.rss.JedisClient;

/**
 * 描述类的功能.
 *
 * @author lijm@missfresh.com
 */
public class RSSTestApplication {

    private JedisClient client = new JedisClient();

    @Test
    public void test1() {
        client.pubMessage("helloWorld", "来了老弟");
    }

}
