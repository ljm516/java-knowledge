package com.javaReview.map;

import java.util.Hashtable;

/**
 * Created by jiangmingli on 2017/11/17.
 */
public class MyHashTable {

    public static void main(String[] args) {

        Hashtable hashtable = new Hashtable();
        hashtable.put(null, null);
        System.out.println(hashtable.get(null));
    }
}
