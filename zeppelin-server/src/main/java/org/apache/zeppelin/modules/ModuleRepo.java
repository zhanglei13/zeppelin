package org.apache.zeppelin.modules;

import org.apache.zeppelin.utils.Pair;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/18.
 */

public enum ModuleRepo {
    repository;

    private Map<Pair<String, String>, Class<?>> map;

    private Map<String, List<ModuleInfo>> modules;

    private ModuleRepo() {
        this.map = new HashMap<>();
        this.modules = new HashMap<>();
    }

    public void init() {
        for (ModuleType type : ModuleType.values()) {
            String directory = type.name();
            File file = new File(this.getClass().getResource("").getPath() + directory);
            if (file.listFiles() == null) continue;

            for (File f : file.listFiles()) {
                try {
                    String name = f.getName().split("\\.")[0];
                    Class<?> cl = Class.forName("org.apache.zeppelin.modules." + directory + "." + name);
                    map.put(new Pair(directory, name), cl);
                    if (cl.isAnnotationPresent(Module.class)) {
                        Module module = cl.getAnnotation(Module.class);
                        String key = module.type().toString();
                        ModuleInfo info = new ModuleInfo(directory, key, name, module.name(), module.description());
                        if (modules.containsKey(key)) modules.get(key).add(info);
                        else {
                            List<ModuleInfo> infos = new ArrayList<>();
                            infos.add(info);
                            modules.put(key, infos);
                        }
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //    public void addRepo(String type, String name) {
//        if (modules.containsKey(type))
//            modules.get(type).add(name);
//        else {
//            List<String> list = new ArrayList<>();
//            list.add(name);
//            modules.put(type, list);
//        }
//    }
//

    public Map<String, String> getModuleParams(String type, String name) {
        Map<String, String> params = new HashMap<>();
        Pair<String, String> pair = new Pair<>(type, name);
        if (!map.containsKey(pair)) return params;
        Class<?> cl = map.get(pair);
        for (Field field : cl.getDeclaredFields()) {
            if (field.isAnnotationPresent(ModuleField.class)) {
                ModuleField f = field.getAnnotation(ModuleField.class);
                params.put(field.getName(), f.desc());
            }
        }
        return params;
    }

    public ModuleBase createModule(String type, String name) {
        ModuleBase moduleBase = null;
        Pair<String, String> pair = new Pair<>(type, name);
        if (map.containsKey(pair)) {
            try {
                moduleBase = (ModuleBase) map.get(pair).newInstance();
                return moduleBase;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Map<String, List<ModuleInfo>> getModules() {
        return modules;
    }

    public static void main(String[] args) {
        ModuleRepo.repository.init();
        Map<String, List<ModuleInfo>> map = ModuleRepo.repository.getModules();
        for (String key : map.keySet()) {
            System.out.print(key + ": ");
            for (ModuleInfo info : map.get(key)) {
                System.out.println(info);
            }
        }
        System.out.println();
//        Map<Pair<String, String>, Class<?>> mm = ModuleRepo.repository.map;
//        for (Map.Entry<Pair<String, String>, Class<?>> entry : mm.entrySet()) {
//            Pair<String, String> key = entry.getKey();
//            System.out.print(key + " ");
//            System.out.println(entry.getValue().getName());
//        }
//        ModuleBase module = ModuleRepo.repository.createModule("input", "FileInput");
//        System.out.println(module);
    }
}
