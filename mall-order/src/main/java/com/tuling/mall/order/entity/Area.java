package com.tuling.mall.order.entity;
import com.tuling.mall.order.entity.TreeFeature;

import java.util.ArrayList;
import java.util.List;

public class Area implements TreeFeature {

    public static List<Area> areaList = new ArrayList<>();

    static {
        areaList.add(new Area("110000","北京市",null));
        areaList.add(new Area("110100","北京市辖区","110000"));
        areaList.add(new Area("110101","东城区","110000"));
        areaList.add(new Area("110102","西城区","110000"));

        areaList.add(new Area("120000","云南省",null));
        areaList.add(new Area("120100","昆明市","120000"));
        areaList.add(new Area("120101","西山区","120100"));
        areaList.add(new Area("120102","五华区","120100"));

        areaList.add(new Area("120200","曲靖市","120000"));
        areaList.add(new Area("120201","麒麟区","120200"));
        areaList.add(new Area("120202","麒麟区2","120200"));



    }

    public Area(String baCode, String baName, String baParentId) {
        this.baCode = baCode;
        this.baName = baName;
        this.baParentId = baParentId;
    }

    public Area() {
    }

    //区域编码
    private String baCode;

    //区域名称
    private String baName;

    //父节点
    private String baParentId;

    //子节点
    private List<Area> childrenList;

    @Override
    public List getChildrenList() {
        return this.childrenList;
    }

    @Override
    public String getNodeId() {
        return this.baCode;
    }

    @Override
    public String getParentId() {
        return this.baParentId;
    }

    @Override
    public void putChildrenList(List children) {
        this.childrenList = children;
    }

    public String getBaName() {
        return baName;
    }

    public void setBaName(String baName) {
        this.baName = baName;
    }

    public static List<Area> getAreaList() {
        return areaList;
    }

    public static void setAreaList(List<Area> areaList) {
        Area.areaList = areaList;
    }

    public String getBaCode() {
        return baCode;
    }

    public void setBaCode(String baCode) {
        this.baCode = baCode;
    }

    public String getBaParentId() {
        return baParentId;
    }

    public void setBaParentId(String baParentId) {
        this.baParentId = baParentId;
    }

    public void setChildrenList(List<Area> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        return "Area{" +
                "baCode='" + baCode + '\'' +
                ", baName='" + baName + '\'' +
                ", baParentId='" + baParentId + '\'' +
                ", childrenList=" + childrenList +
                '}';
    }

    @Override
    public String getNodeName() {
        return this.baName;
    }
}