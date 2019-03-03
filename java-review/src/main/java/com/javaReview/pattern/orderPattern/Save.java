package com.javaReview.pattern.orderPattern;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Save implements Action {

    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
