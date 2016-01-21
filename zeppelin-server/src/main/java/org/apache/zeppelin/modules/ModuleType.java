package org.apache.zeppelin.modules;

/**
 * Created by zhanglei on 2016/1/15.
 */
public enum ModuleType {
    input("输入"),
    output("输出"),
    others("其他");

    private String value;

    private ModuleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
