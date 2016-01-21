package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.UDF;
import org.apache.zeppelin.modules.ModuleBase;
import org.apache.zeppelin.modules.ModuleData;

/**
 * Created by zhanglei on 2016/1/18.
 */
public class DBInput  {
    private String url = "jdbc:mysql://127.0.0.1:3306/test";
    private String dbtable = "test";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "123456";

    public DBInput() {
        super();
    }
}
