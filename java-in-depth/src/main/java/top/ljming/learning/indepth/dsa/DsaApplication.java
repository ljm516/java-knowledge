package top.ljming.learning.indepth.dsa;

import com.alibaba.fastjson.JSONObject;
import top.ljming.learning.indepth.dsa.sort.QuickSort;

/**
 * dsa(data structure and algorithms).
 *
 * @author lijm
 */
public class DsaApplication {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 3, 23, 13, 17, 15, 21, 11, 19};
        //BubbleSort.ascSort(arr);
        //SelectSort.sort(arr);
        //InsertSort.sort(arr);
        //ShellSort.sort(arr);
        //MergeSort.mergeSort(arr);
        QuickSort.sort(arr);

        System.out.println(JSONObject.toJSONString(arr));
    }
}
