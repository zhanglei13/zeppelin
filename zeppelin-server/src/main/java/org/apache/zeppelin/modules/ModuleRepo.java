package org.apache.zeppelin.modules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/18.
 */

public enum ModuleRepo {
    repository;

    private Map<String, List<String>> modules;

    private ModuleRepo() {
        this.modules = new HashMap<>();
    }

    public void addRepo(String type, String name) {
        if (modules.containsKey(type))
            modules.get(type).add(name);
        else {
            List<String> list = new ArrayList<>();
            list.add(name);
            modules.put(type, list);
        }
    }

    public Map<String, List<String>> getModules() {
        return modules;
    }
}
