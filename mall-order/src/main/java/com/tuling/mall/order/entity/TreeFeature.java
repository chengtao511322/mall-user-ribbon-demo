package com.tuling.mall.order.entity;

import java.util.List;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public interface TreeFeature<V> {

    /**
     * 获得节点id
     * @return
     */
    String getNodeId();

    /**
     * 获得父节点id
     */
    String getParentId();

    /**
     * 设置子节点
     */
    void putChildrenList(List<V> childrenList);

    /**
     * 获得子节点
     */
    List<V> getChildrenList();

    /**
     * 获得子节点名称
     */
    String getNodeName();



}
