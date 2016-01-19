package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.UDF;
import org.apache.zeppelin.modules.Module;
import org.apache.zeppelin.modules.ModuleData;

import java.util.Map;

/**
 * Created by zhanglei on 2016/1/18.
 */
public class DBInput extends Module {
    private String url = "jdbc:mysql://127.0.0.1:3306/test";
    private String dbtable = "test";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "123456";

    public DBInput() {
        super();
        initConf();
    }

    @Override
    public ModuleData execute() {
        this.cmd = new UDF().ss();
        udf = decode(udf, config);
        cmd = decode(cmd, config);
        return null;
    }

    @Override
    public void initConf() {
        config.put("url", url);
        config.put("dbtable", dbtable);
        config.put("driver", driver);
        config.put("user", user);
        config.put("password", password);
    }

    public static void main(String[] args) {
        DBInput db = new DBInput();
        db.execute();
    }
}
