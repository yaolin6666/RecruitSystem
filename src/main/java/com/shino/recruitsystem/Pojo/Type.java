package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("type")
public class Type {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("father_uuid")
    private Long father_UUID;
    @TableField("content")
    private String content;
    @Version
    private Integer version;
}
