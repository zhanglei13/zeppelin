package org.apache.zeppelin.modules;

import org.apache.zeppelin.udf.UDF;

import java.util.Map;

/**
 * Created by zhanglei on 2016/1/13.
 */
public abstract class Module {
    private UDF udf;
    private ModuleType type;
    private Map<String, Object> config;
    private String name;
    private String description;
    private ModuleData in;
    private ModuleData out;

    public Module() {
    }

    public abstract ModuleData execute(Map<String, Object> config);

    public abstract void initConf();

    public String getConf(){
        return null;
    }

    public void registerModule(){
    }
}
