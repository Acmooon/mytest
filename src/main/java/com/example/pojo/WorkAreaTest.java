package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("work_area_test")
public class WorkAreaTest {
    @TableId
    private String areaId;
    private String areaName;
    private String parentId;
}
