package com.javaReview.pattern.strategyPattern;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class GzipCompressionStrategy implements CompressionStrategy {

    @Override
    public OutputStream compress(OutputStream data) throws Exception {
        return new GZIPOutputStream(data);
    }
}
