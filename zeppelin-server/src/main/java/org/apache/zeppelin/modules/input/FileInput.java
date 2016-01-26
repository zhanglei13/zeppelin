package org.apache.zeppelin.modules.input;

import org.apache.zeppelin.modules.*;
import org.apache.zeppelin.service.common.CMDUtils;

import java.util.Map;

/**
 * Created by zhanglei on 16-1-26.
 */

@Module(name = "文件输入", type = ModuleType.input)
public class FileInput extends ModuleBase {
    @ModuleField(desc = "路径")
    private String path;

    @Override
    public void execute(ModuleData data, Map<String, String> config) {
        System.out.println(data.getId());
        String cmd = "val " +data.getId()+ " = sqlContext.read.json(\"file:///opt/spark-1.4.1-bin-hadoop2.6/examples/src/main/resources/people.json\")";
        System.out.println(cmd);
        CMDUtils.execute(cmd);
    }
}
