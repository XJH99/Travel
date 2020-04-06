package com.jxust.bean;

import java.io.Serializable;

/**
 * 权限实体类
 */
public class Permission implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String route;
    private String type;
    private String icon;
    private Integer parent_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", route='" + route + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
