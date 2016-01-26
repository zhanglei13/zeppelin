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
        String id = "DF_" + randomID();
        historyDF.add(id);
        return id;
    }

    public static String getPrevId() {
        return historyDF.isEmpty() ? null : historyDF.get(historyDF.size() - 1);
    }

    public static List<String> getDFSchema(String id) {
     //   CMDUtils.execute(id + ".registerTempTable(\"" + id + "\")");
        InterpreterResult result =  CMDUtils.execute(id + ".columns.mkString(\",\")");
        List<String> cols = new ArrayList<>();
        String meta = result.message().split("=")[1].trim();
        for (String s : meta.split(",")) {
            cols.add(s);
        }
        return cols;
    }

    public static List<String> getDFSchema() {
        if(historyDF.isEmpty()) return new ArrayList<>();
        return getDFSchema(historyDF.get(historyDF.size() - 1));
    }

    public static List<List<String>> getDFData(String id) {
        String cmd = id + ".collect.mkString(\"\\n\")";
        List<List<String>> data = new ArrayList<>();
        String meta = CMDUtils.execute(cmd).message().split("=")[1].trim();

        for (String ss : meta.split("\n")) {
            if(ss.equals(" "))  continue;
            ss = ss.substring(1, ss.length()-1);
            List<String> list = new ArrayList<>();
            for(String ele : ss.split(",")) {
                list.add(ele);
            }
            data.add(list);
        }
        return data;
    }

    public static List<List<String>> getDFData() {
        if(historyDF.isEmpty()) return new ArrayList<>();
        return getDFData(historyDF.get(historyDF.size() - 1));
    }

    public static void main(String[] args) {
        String s = "res24: String = age,name";

        //String t = "res26: String = {\"name\":\"Michael\"},{\"age\":30,\"name\":\"Andy\"},{\"age\":19,\"name\":\"Justin\"}";
        String t = "res21: String = \n" +
                "[null,Michael]\n" +
                "[30,Andy]\n" +
                "[19,Justin]";
        List<List<String>> data = new ArrayList<>();
        String meta = t.split("=")[1];

        for (String ss : meta.split("\n")) {
            if(ss.equals(" "))  continue;
            ss = ss.substring(1, ss.length()-1);
            List<String> list = new ArrayList<>();
            for(String ele : ss.split(",")) {
                list.add(ele);
            }
            data.add(list);
        }

        for (List<String> x : data) {
            for(String y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

//        for (String ss : meta.split(",")) {
//            if(ss.equals(" "))   continue;
//            System.out.println(ss);
//            cols.add(ss);
//        }
    }
}
