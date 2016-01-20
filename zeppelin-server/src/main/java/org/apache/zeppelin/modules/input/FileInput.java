package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.UDF;
import org.apache.zeppelin.modules.*;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Module(name = "数据库输入", type = ModuleType.input)
public class FileInput extends ModuleBase {
    @ModuleField(desc = "url地址")
    private String url = "jdbc:mysql://127.0.0.1:3306/test";

    @ModuleField(desc = "数据表")
    private String dbtable = "test";

    @ModuleField(desc = "驱动")
    private String driver = "com.mysql.jdbc.Driver";

    @ModuleField(desc = "用户名")
    private String user = "root";

    @ModuleField(desc = "密码")
    private String password = "123456";

    @ModuleUDF
    private String cmd = new UDF().ss();

    @Override
    public ModuleData execute() {
        return null;
    }

    public FileInput() {
        super();
        transferParams();
    }
}
