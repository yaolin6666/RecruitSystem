package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("job")
public class Job {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("type_uuid")
    private Long type_UUID;
    @TableField("boss_uuid")
    private Long boss_UUID;
    @TableField("name")
    private String name;
    @TableField("type")
    private String type;
    @TableField("salary_num")
    private Double salary_Num;
    @TableField("salary_unit")
    private String salary_Unit;
    @TableField("description")
    private String description;
    @TableField("requirement")
    private String requirement;
    @Version
    private Integer version;
}
