package org.apache.zeppelin.modules;

/**
 * Created by zhanglei on 2016/1/15.
 */
public enum ModuleType {
    input("input", "输入"),
    output("output", "输出"),
    others("others", "其他");

    private String name;
    private String value;

    private ModuleType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
