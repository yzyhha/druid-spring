package com.yzy.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    @GetMapping("/addList")
    public String addUSer(){
        String sql = "insert into mybatis.user (id,name,pwd) value (50,'小米','123456')";
        jdbcTemplate.update(sql);
        return "Successful";

    }
    @GetMapping("/updateList/{id}")
    public String updateUSer(@PathVariable("id")int id){
        String sql = "update mybatis.user set name=?,pwd=? where id="+id;
        Object[] objects = new Object[2];
        objects[0]="笑话";
        objects[1]="zzzzzz";
        jdbcTemplate.update(sql,objects);
        return "update-success";

    }
    @GetMapping("/delList/{id}")
    public String delUSer(@PathVariable("id") int id){
        String sql = "delete from mybatis.user where id=?";
        jdbcTemplate.update(sql,id);
        return "Delete-Successful";

    }
}
