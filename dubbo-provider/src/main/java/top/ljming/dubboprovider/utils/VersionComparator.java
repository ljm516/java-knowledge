package top.ljming.dubboprovider.utils;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * 版本号比较.
 *
 * @author lijm
 */
public class VersionComparator {

    public static void main(String[] args) {
        String va = "v9.0.1.3a";
        String vb = "V9.0.1.3a";

        compare(va, vb);
    }

    private static int compare(String versionA, String versionB) {
        if (versionA.length() > 4 || versionB.length() > 4) {
            return -2;
        }
        List<String> vaCharList = Splitter.on(".").splitToList(versionA);
        List<String> vbCharList = Splitter.on(".").splitToList(versionB);
            while (vaCharList.size() != vbCharList.size()) {
            if (vaCharList.size() > vbCharList.size()) {
                vbCharList.add("0");
            } else {
                vaCharList.add("0");
            }
        }

        versionA = removeSpecialChar(versionA);
        versionB = removeSpecialChar(versionB);
        System.out.println("versionA: " + versionA);
        System.out.println("versionB: " + versionB);
        return 0;
    }


    private static String removeSpecialChar(String s) {
        return s.replaceAll("[a-zA-Z]", "");
    }
}
