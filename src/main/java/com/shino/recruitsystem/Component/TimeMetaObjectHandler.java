package com.shino.recruitsystem.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TimeMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info(LocalDateTime.now()+":start insert fill");
        this.strictInsertFill(metaObject,"create_time",LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject,"update_time",LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info(LocalDateTime.now()+":start update fill");
        this.strictInsertFill(metaObject,"update_time",LocalDateTime.class,LocalDateTime.now());
    }
}