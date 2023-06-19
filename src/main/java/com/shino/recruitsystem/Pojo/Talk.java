package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("talk")
public class Talk {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("seeker_uuid")
    private Long seeker_UUID;
    @TableField("boss_uuid")
    private Long boss_UUID;
    @TableField("content")
    private String content;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;
}
