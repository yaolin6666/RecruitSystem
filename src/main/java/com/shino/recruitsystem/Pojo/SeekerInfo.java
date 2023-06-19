package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("seekerinfo")
public class SeekerInfo {
    @TableId(value = "uuid",type = IdType.INPUT)
    private Long UUID;
    @TableField("name")
    private String name;
    @TableField("id")
    private String ID;
    @TableField("email")
    private String email;
    @TableField("age")
    private Integer age;
    @TableField("location")
    private String location;
    @TableField("status")
    private String status;
    @TableField("salary_expected_num")
    private Double salary_expected_num;
    @TableField("salary_expected_unit")
    private String salary_expected_unit;
    @TableField("phone")
    private String phone;
    @TableField("education")
    private String education;
    @TableField("sex")
    private String sex;
    @Version
    private Integer version;
}
