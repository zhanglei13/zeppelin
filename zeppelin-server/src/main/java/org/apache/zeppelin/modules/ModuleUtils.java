package org.apache.zeppelin.modules;

import org.apache.zeppelin.modules.input.FileInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/19.
 */
public class ModuleUtils {
    private static List<String> getTypeNames() {
        List<String> names = new ArrayList<>();
        for (ModuleType type : ModuleType.values()) {
            names.add(type.toString());
        }
        return names;
    }

    private static Map<String, List<String>> getTypeModules() {
        return ModuleRepo.repository.getModules();
    }

    public static void main(String[] args) {
//        for (String s : ModuleUtils.getTypeNames()) {
//            System.out.println(s);
//        }
        FileInput module = new FileInput();
        Map<String, List<String>> repos = getTypeModules();
        for (String key : repos.keySet()) {
            System.out.print(key + ":  ");
            for (String s : repos.get(key)) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        Map<String, String> map = module.getParams();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
