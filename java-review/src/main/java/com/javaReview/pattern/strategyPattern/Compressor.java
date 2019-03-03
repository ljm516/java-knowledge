package com.javaReview.pattern.strategyPattern;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by jiangmingli on 2017/10/19.
 */
public class Compressor {
    private final CompressionStrategy compressionStrategy;

    public Compressor(CompressionStrategy compressionStrategy) {
        this.compressionStrategy = compressionStrategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(outFile)){
            Files.copy(inFile, compressionStrategy.compress(outputStream));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
