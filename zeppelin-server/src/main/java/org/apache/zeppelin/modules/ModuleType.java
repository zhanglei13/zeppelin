package org.apache.zeppelin.modules;

/**
 * Created by zhanglei on 2016/1/15.
 */
public enum ModuleType {
    input("输入"),
    output("输出"),
    attrib("属性操作"),
    cleansing("数据清理"),
    operation("数据操作"),
    others("其他");

    private String value;

    ModuleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
