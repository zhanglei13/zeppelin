package org.apache.zeppelin.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/19.
 */
public class ModuleProxy {
    public static List<String> getTypeNames() {
        List<String> names = new ArrayList<>();
        for (ModuleType type : ModuleType.values()) {
            names.add(type.toString());
        }
        return names;
    }

    public static Map<String, List<ModuleInfo>> getTypeModules() {
        return ModuleRepo.repository.getModules();
    }

    public static Map<String, String> getModuleParams(String type, String name) {
        return ModuleRepo.repository.getModuleParams(type, name);
    }


    public static ModuleBase createModule(String type, String name) {
        return ModuleRepo.repository.createModule(type, name);
    }

    public static void executeModule(String type, String name, ModuleData data, Map<String, String> config) {
        ModuleBase module = createModule(type, name);
        module.execute(data, config);
    }
}
