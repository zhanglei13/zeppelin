package org.apache.zeppelin.service.common;

import org.apache.zeppelin.interpreter.InterpreterResult;

import java.util.List;

/**
 * Created by zhanglei on 2016/1/19.
 */
public class DFUtils {
    private static long id = 0;
    private static List<String> savedDF;
    private static List<String> historyDF;

    public static long randomID() {
        return id++;
    }

    public static String createDF() {
        String id = randomID() + "_DF";
        historyDF.add(id);
        return id;
    }

    public static InterpreterResult getDFData(String id) {
        String cmd = id + ".show";
        return CMDUtils.execute(cmd);
    }

    public static InterpreterResult getDFData() {
        return getDFData(historyDF.get(historyDF.size() - 1));
    }
}
