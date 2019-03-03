package com.javaReview.pattern.orderPattern;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Open implements Action {

    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
