package org.apache.zeppelin.modules.operation;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;

import java.util.Map;

@Module(name = "排序", type = ModuleType.operation)
public class SortBy extends ModuleBase {
    @ModuleField(desc = "列名")
    public String column;

//    @ModuleField(desc = "顺序")
//    public int order;

    public SortBy(){}

    @ModuleUDF
    public String cmd =
            "val @out=@in.orderBy(\"@column\")";

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        CMDUtils.execute(cmd);
    }
}
