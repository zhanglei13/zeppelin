package org.apache.zeppelin.modules.cleansing;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;

import java.util.Map;

@Module(name = "重复值清理", type = ModuleType.cleansing)
public class DropDuplicates extends ModuleBase {
    public DropDuplicates(){}

    @ModuleUDF
    public String cmd =
            "val @out=@in.dropDuplicates";

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        CMDUtils.execute(cmd);
    }
}
