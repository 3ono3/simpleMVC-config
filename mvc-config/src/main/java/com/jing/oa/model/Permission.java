package com.jing.oa.model;

/**
 * 权限类
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public class Permission {
    private String id;

    private String title;

    private String instructions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }
}
