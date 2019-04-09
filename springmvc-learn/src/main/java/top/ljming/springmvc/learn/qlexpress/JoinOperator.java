package top.ljming.springmvc.learn.qlexpress;

import com.ql.util.express.Operator;

import java.util.ArrayList;
import java.util.List;

public class JoinOperator extends Operator {

    public Object executeInner(Object[] list) throws Exception {
        List result = new ArrayList();
        for (Object o : list) {
            if (o instanceof java.util.List) {
                result.addAll((java.util.List) o);
            } else {
                result.add(o);
            }
        }
        return result;
    }
}
