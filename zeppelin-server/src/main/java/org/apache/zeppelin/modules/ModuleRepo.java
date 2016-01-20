package org.apache.zeppelin.modules;

import javafx.util.Pair;

import java.io.File;
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
            File file = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "\\org\\apache\\zeppelin\\modules\\" + directory);
            //     System.out.println(ModuleRepo.class.getResource("").getPath());
            if (file.listFiles() == null) continue;

            for (File f : file.listFiles()) {
                try {
                    String name = f.getName().split("\\.")[0];
                    Class<?> cl = Class.forName("org.apache.zeppelin.modules." + directory + "." + name);
                    map.put(new Pair<>(directory, name), cl);
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
//    public Map<String, List<String>> getModules() {
//        return modules;
//    }

    public static void main(String[] args) {
        ModuleRepo.repository.init();
    }
}
