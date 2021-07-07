package com.tuling.mall.order.entity;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class TreeUtil {

    private static int num = 0;


    /**
     * 方法入口
     */
    public static <V extends TreeFeature<V>> List<V> build(List<V> all,String rootNodeId){
        if(CollectionUtils.isEmpty(all)){
            return new ArrayList<>();
        }

        //1.获取根节点集合
        List<V> roots = all.stream().filter(item -> item.getNodeId().equals(rootNodeId) || item.getParentId()==null).collect(Collectors.toList());
        //2.获取所有其他节点
        List<V> others = all.stream().filter(item -> item.getParentId() != null).collect(Collectors.toList());


        return buildTree(roots,others);
    }

    /**
     * 构建树方法
     */
    public static <V extends TreeFeature<V>> List<V> buildTree(List<V> roots,List<V> others){
        if(!CollectionUtils.isEmpty(roots)){
            //1.定义一个map，用来记录已经操作过的节点
            Map<String,String> map = new ConcurrentHashMap<>();
            //1.从根节点往下遍历
            roots.stream().forEach(beanTree->{
                List<V> childrenList = new ArrayList<>();
                others.stream()
                        .filter(c -> c.getParentId().equals(beanTree.getNodeId()))
                        .forEach(c->{
                            //System.out.println("添加子集之前的"+c+"num=="+num);
                            addChildren(others,c,map);
                            //System.out.println("添加子集之后的------"+c+"num=="+num);
                            childrenList.add(c);
                        });
              beanTree.putChildrenList(childrenList);
            });
            return roots;
        }
        return new ArrayList<>();
    }

    /**
     * 添加子集
     */
    public static  <V extends TreeFeature<V>> void addChildren(List<V> others,V beanTree,Map map){
        List<V> childrenList = new ArrayList<>();
        //1.遍历所有集合
        others.stream()
                .filter(c-> !map.containsKey(c.getNodeId()))
                .filter(c-> beanTree.getNodeId().equals(c.getParentId()))
                .forEach(c->{
                    map.put(c.getNodeId(),c.getParentId());
                    //递归调用
                    addChildren(others,c,map);
                    childrenList.add(c);
                });
        beanTree.putChildrenList(childrenList);
    }

    public static void main(String[] args) {
        List<Area> areaList = Area.areaList;
        List<Area> build = TreeUtil.build(areaList, null);
        for (Area area : build) {
            System.out.println(area);
        }
    }
}
