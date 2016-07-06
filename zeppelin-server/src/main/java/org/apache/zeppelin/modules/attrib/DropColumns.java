package org.apache.zeppelin.modules.attrib;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;

import java.util.Map;

@Module(name = "删除列", type = ModuleType.attrib)
public class DropColumns extends ModuleBase {
    @ModuleField(desc = "列名")
    public String column;

    public DropColumns(){}

    @ModuleUDF
    public String cmd =
            "val @out=@in.drop(\"@column\")";

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        CMDUtils.execute(cmd);
    }
}
