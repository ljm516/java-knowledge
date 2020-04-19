package top.ljming.learning.indepth.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述类的功能.
 *
 * @author lijm
 */
public class ListSpliter {

    /**
     * 将列表切分.
     *
     * @param originList 原数据列表
     * @param preCnt 每个子列表个数
     * @return 子列表的集合
     */
    public static <T>List<List<T>> split(List<T> originList, int preCnt) {
        if(null == originList || originList.size() == 0) {
            return null;
        }
        preCnt = preCnt <= 0 ? 1000 : preCnt; // 默认1000个一组
        List<List<T>> resultList = new ArrayList<>();
        int subSize = originList.size() % preCnt == 0 ? originList.size() / preCnt : ( originList.size() / preCnt) + 1;
        int fromIndex;
        int toIndex;
        for (int i = 0; i < subSize; i++) {
            fromIndex = i*preCnt;
            toIndex = i * preCnt + preCnt > originList.size() ? originList.size() : i * preCnt + preCnt;
            List<T> subList = originList.subList(fromIndex, toIndex);
            resultList.add(subList);
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> originList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            originList.add(i);
        }
        List<List<Integer>> result = split(originList, 101);
        System.out.println("size:" + result.size());
        for (List<Integer> subList : result) {
            System.out.println(subList.size());
        }
    }
}
