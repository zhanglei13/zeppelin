package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;
import org.apache.zeppelin.service.common.DFUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Module(name = "数据库输入", type = ModuleType.input)
public class DBInput extends ModuleBase {
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
    public String cmd =
            "val @in = sqlContext.read.format(\"jdbc\").options(\n" +
            "Map(\"url\"->\"@url\", \"driver\"->\"@driver\", \"dbtable\"->\"@dbtable\", \"user\"->\"@user\", \"password\"->\"@password\")\n" +
            ").load()";

    public DBInput() {
        super();
    }

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        CMDUtils.execute(cmd);
    }

    public static void main(String[] args) {
        DBInput input = new DBInput();
        ModuleData data = new ModuleData("df_1");
        Map<String, String> config = new HashMap<>();
        config.put("url", "123");
        config.put("user", "root");
        input.process(data, config);
        System.out.println(input.cmd);
    }

}
