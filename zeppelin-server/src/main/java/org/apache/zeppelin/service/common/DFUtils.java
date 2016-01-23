package org.apache.zeppelin.service.common;

import org.apache.zeppelin.interpreter.InterpreterResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglei on 2016/1/19.
 */
public class DFUtils {
    // 只支持一个用户，需要改进
    private static long id = 0;
    private static List<String> savedDF = new ArrayList<>();
    private static List<String> historyDF = new ArrayList<>();

    public static long randomID() {
        return id++;
    }

    public static String createDFId() {
        String id = randomID() + "_DF";
        historyDF.add(id);
        return id;
    }

    public static String getPrevId() {
        return historyDF.isEmpty() ? null : historyDF.get(historyDF.size()-1);
    }

    public static InterpreterResult getDFData(String id) {
        String cmd = id + ".collect";
        return CMDUtils.execute(cmd);
    }

    public static InterpreterResult getDFData() {
        return getDFData(historyDF.get(historyDF.size() - 1));
    }
}
