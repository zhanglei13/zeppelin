package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.modules.Module;
import org.apache.zeppelin.modules.ModuleBase;
import org.apache.zeppelin.modules.ModuleData;
import org.apache.zeppelin.modules.ModuleType;

import java.util.Map;

/**
 * Created by zhanglei on 2016/1/18.
 */

@Module(name = "文件输入", type = ModuleType.input)
public class DBInput extends ModuleBase{
    private String url = "jdbc:mysql://127.0.0.1:3306/test";
    private String dbtable = "test";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "123456";

    public DBInput() {
        super();
    }

    @Override
    public ModuleData execute(ModuleData data, Map<String, String> config) {
        return null;
    }
}
