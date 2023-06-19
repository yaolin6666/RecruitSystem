package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("bossinfo")
public class BossInfo {
    @TableId(value = "uuid",type = IdType.INPUT)
    private Long UUID;
    @TableField("name")
    private String name;
    @TableField("company_name")
    private String company_name;
    @TableField("address")
    private String address;
    @TableField("introduction")
    private String introduction;
    @Version
    private Integer version;
}
