package org.apache.zeppelin.utils;

import java.util.List;

/**
 * Created by zhanglei on 16-4-9.
 */
public class TableData {
    List<String> header;
    List<List<String>> data;

    public TableData() {

    }

    public TableData(List<String> header, List<List<String>> data) {
        this.header = header;
        this.data = data;
    }

    public List<String> getHeader() {
        return header;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }
}
