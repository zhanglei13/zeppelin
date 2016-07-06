package org.apache.zeppelin.modules.operation;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;

import java.util.Map;

@Module(name = "数据筛选", type = ModuleType.operation)
public class Filter extends ModuleBase {

    @ModuleField(desc = "条件")
    public String sql;

    public Filter(){}

    @ModuleUDF
    public String cmd =
            "val @out=@in.filter(\"@sql\")";

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        CMDUtils.execute(cmd);
    }
}
