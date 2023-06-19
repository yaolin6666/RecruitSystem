package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@TableName("resume")
public class Resume {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("seeker_uuid")
    private Long seeker_UUID;
    @TableField("content")
    private String content;
    @TableField("type")
    private String type;
    @Version
    private Integer version;
}
