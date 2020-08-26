package top.ljming.javaindepth.file;

import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
public class DataProcessor {

    public static void main(String[] args) throws IOException {
        String sourceFile = "/Users/my/xyy/docs/industry/source.txt";
        String storeFile = "/Users/my/xyy/docs/industry/store_type.txt";


        BufferedReader sourceReader = new BufferedReader(new FileReader(sourceFile));
        Map<String, List<String>> priceMap = new HashMap<>(1024);
        List<String> contentList = sourceReader.lines().collect(Collectors.toList());
        for (int i = 1; i < contentList.size(); i++) {
            String line = contentList.get(i);
            String[] contextArr = line.split("\t");
            if (priceMap.containsKey(contextArr[6])) {
                if (!priceMap.get(contextArr[6]).contains(contextArr[9])) {
                    priceMap.get(contextArr[6]).add(contextArr[9]);
                }
            } else {
                List<String> priceList = new ArrayList<>();
                priceList.add(contextArr[9]);
                priceMap.put(contextArr[6], priceList);
            }
        }
        sourceReader.close();

        List<String> newStoreContent = new ArrayList<>();
        BufferedReader storeReader = new BufferedReader(new FileReader(storeFile));
        storeReader.lines().forEach(line -> {
            String[] arr = line.split("\t");
            String saasNo = arr[0];
            List<String> priceList = priceMap.get(saasNo);
            if (CollectionUtils.isEmpty(priceList)) {
                System.out.println("没有price数据： " + saasNo);
            } else {
                newStoreContent.add(priceList.get(0));
            }
        });
        storeReader.close();

        String newFile = "/Users/my/xyy/docs/industry/store_type_prices.txt";
        BufferedWriter resultWrite = new BufferedWriter(new FileWriter(newFile));
        for (String context : newStoreContent) {
            resultWrite.write(context);
            resultWrite.write("\n");
        }

        resultWrite.close();
    }
}
