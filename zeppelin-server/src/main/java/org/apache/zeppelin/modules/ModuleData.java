package org.apache.zeppelin.modules;

/**
 * Created by zhanglei on 2016/1/18.
 */
public class ModuleData {
    private String id;
    private String prev;
    private String info;
    private boolean isDF;

    public ModuleData(String id) {
        this.prev = null;
        this.id = id;
        this.info = null;
        this.isDF = true;
    }

    public ModuleData(String prev, String id) {
        this.prev = prev;
        this.id = id;
    }

    public ModuleData(String prev, String id, String info, boolean isDF) {
        this.prev = prev;
        this.id = id;
        this.info = info;
        this.isDF = isDF;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isDF() {
        return isDF;
    }

    public void setIsDF(boolean isDF) {
        this.isDF = isDF;
    }
}
