package org.apache.zeppelin.utils;

/**
 * Created by zhanglei on 16-4-11.
 */
public class DataEntity {
    private String msg;

    private TableData tableData;

    public DataEntity() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }
}
