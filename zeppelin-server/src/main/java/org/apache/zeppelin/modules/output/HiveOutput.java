package org.apache.zeppelin.modules.output;

import org.apache.zeppelin.modules.Module;
import org.apache.zeppelin.modules.ModuleBase;
import org.apache.zeppelin.modules.ModuleData;
import org.apache.zeppelin.modules.ModuleType;

import java.util.Map;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Module(name = "Hive输出", type = ModuleType.output)
public class HiveOutput extends ModuleBase {
    @Override
    public void execute(ModuleData data, Map<String, String> config) {

    }
}
