package com.javaReview.pattern.strategyPattern;

import java.io.OutputStream;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws Exception;

}
