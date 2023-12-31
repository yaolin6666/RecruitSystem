package com.shino.recruitsystem.Pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@TableName("recruit")
public class Recruit {
    @TableId(value = "uuid",type = IdType.ASSIGN_ID)
    private Long UUID;
    @TableField("seeker_uuid")
    private Long seeker_UUID;
    @TableField("job_uuid")
    private Long job_UUID;
    @TableField("resume_uuid")
    private Long resume_UUID;
    @TableField("status")
    private String status;
    @Version
    private Integer version;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime create_time;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime update_time;
}
