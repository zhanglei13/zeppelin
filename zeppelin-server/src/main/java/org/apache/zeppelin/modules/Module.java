package org.apache.zeppelin.modules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglei on 2016/1/13.
 */
public abstract class Module {
    protected String udf;
    protected String cmd;
    protected ModuleType type;
    protected Map<String, String> config;
    protected String name;
    protected String description;
    protected ModuleData in;
    protected ModuleData out;

    public Module() {
        config = new HashMap<>();
    }

    public abstract ModuleData execute();

    public abstract void initConf();

    public String getConf(){
        return null;
    }

    public String decode(String cmd, Map<String, String> config) {
        if(cmd == null || cmd.equals(""))   return cmd;
        for (String key : config.keySet()) {
            String origin = "@" + key;
            cmd = cmd.replaceAll(origin, config.get(key));
        }
        return cmd;
    }

    public void registerModule(){
    }
}
