package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.github.jeffreyning.mybatisplus.conf.EnableAutoFill;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("account")
public class Account {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("role")
    private String role;
    @Version
    private Integer version;
}
