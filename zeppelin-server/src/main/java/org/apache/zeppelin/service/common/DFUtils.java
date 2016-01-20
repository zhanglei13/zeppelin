package org.apache.zeppelin.service.common;

import java.util.List;

/**
 * Created by zhanglei on 2016/1/19.
 */
public class DFUtils {
    private static long id = 0;
    private List<String> savedDF;
    private List<String> historyDF;

    public long randomID() {
        return id++;
    }

    public String createDF() {
        String id = randomID()+"_DF";
        historyDF.add(id);
        return id;
    }

    public void getDFData(String id) {

    }

    public void getDFData() {

    }
}
