package org.apache.zeppelin.modules;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/13.
 */
public abstract class ModuleBase {

    public ModuleBase() {
//        params = new LinkedHashMap<>();
//        this.initConf();
        //   this.register();
    }

    public abstract ModuleData execute(ModuleData data, Map<String, String> config);

//    public void initConf() {
//        Class<?> cl = this.getClass();
//        for (Field field : cl.getDeclaredFields()) {
//            if (field.isAnnotationPresent(ModuleField.class)) {
//                ModuleField f = field.getAnnotation(ModuleField.class);
//                params.put(field.getName(), f.desc());
//            }
//        }
//    }

//    public void register() {
//        Class<?> cl = this.getClass();
//        Module module = cl.getAnnotation(Module.class);
//        ModuleRepo.repository.addRepo(module.type().toString(), module.name());
//    }

    public void transferParams() {
        Class<?> cl = this.getClass();
        List<Field> cmds = new ArrayList<>();
        List<Field> fields = new ArrayList<>();

        for (Field field : cl.getDeclaredFields()) {
            if (field.isAnnotationPresent(ModuleUDF.class))
                cmds.add(field);
            if (field.isAnnotationPresent(ModuleField.class))
                fields.add(field);
        }

        for (Field cmdField : cmds) {
            cmdField.setAccessible(true);
            try {
                String cmd = (String) cmdField.get(this);
                if (cmd == null || cmd.equals("")) continue;
                for (Field field : fields) {
                    field.setAccessible(true);
                    String key = "@" + field.getName();
                    String value = (String) field.get(this);
                    cmd = cmd.replaceAll(key, value);
                }
                cmdField.set(this, cmd);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
