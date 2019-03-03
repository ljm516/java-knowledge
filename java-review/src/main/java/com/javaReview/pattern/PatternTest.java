package com.javaReview.pattern;

import com.javaReview.pattern.orderPattern.Editor;
import com.javaReview.pattern.orderPattern.Macro;
import com.javaReview.pattern.orderPattern.Open;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class PatternTest {

    static Editor editor ;

    public static void main(String[] args) {
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.run();
    }
}
