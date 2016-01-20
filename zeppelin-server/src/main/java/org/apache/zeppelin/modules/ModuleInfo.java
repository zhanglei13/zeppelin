package org.apache.zeppelin.modules;

/**
 * Created by zhanglei on 2016/1/20.
 */
public class ModuleInfo {
    private String type;

    private String typeCN;

    private String name;

    private String nameCN;

    private String decription;

    public ModuleInfo(String type, String typeCN, String name, String nameCN, String decription) {
        this.type = type;
        this.typeCN = typeCN;
        this.name = name;
        this.nameCN = nameCN;
        this.decription = decription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeCN() {
        return typeCN;
    }

    public void setTypeCN(String typeCN) {
        this.typeCN = typeCN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
