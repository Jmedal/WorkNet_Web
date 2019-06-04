package com.example.worknet.common.persistence.affair.profession.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 职业表 前端控制器
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-05-25
 */
@Controller
@ResponseBody
public class ProfessionController {

    //获取职业图
    @RequestMapping(value = "/get/vocations/graph")
    public String getVocationGraph(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        map.put("errorCode","00");
        HashMap<String,Object> graph = new HashMap<>();//图
        List<HashMap<String,Object>> nodes = new ArrayList<>();//节点
        List<HashMap<String,Object>> edges = new ArrayList<>();//边
        for(int i = 0;i < 10; i++){
            HashMap<String,Object> node = new HashMap<>();
            node.put("jobId",i);//职业id
            node.put("isLeaf",false);//是否是叶子节点，也就是说是可以被选择的职业还是概括性的职业
            node.put("name","前端"+i);//职业名称
            for(int j = 0;j < 20; j++){
                HashMap<String,Object> node2 = new HashMap<>();
                node2.put("jobId",i+"0"+j);//职业id,职业id具有唯一性
                node2.put("isLeaf",true);//是否是叶子节点
                node2.put("name","php开发工程师"+i);//职业名称
                nodes.add(node2);
                HashMap<String,Object> edge = new HashMap<>();
                edge.put("fromId",i);//边出发
                edge.put("toId",i+"0"+j);//边终止
                edges.add(edge);//添加边
            }
            nodes.add(node);
        }
        graph.put("nodes",nodes);
        graph.put("edges",edges);
        map.put("returnObject",graph);
        return JSON.toJSONString(map);
    }

    //用户选定目标职业，返回00表示成功，否则失败
    //uid从session中获取
    @RequestMapping(value = "/join/vocation/{jobId}")
    public String joinVocation(@PathVariable Integer jobId){
        HashMap<String,Object> map = new HashMap<>();
        map.put("errorCode","00");
        return JSON.toJSONString(map);
    }
}

