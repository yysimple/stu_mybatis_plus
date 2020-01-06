package com.example.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author wcx
 * @date 2020/1/5 22:25
 * <p>
 * 自定义填充handler
 * 当你在类的属性上添加了@TableFIeld(fill = ...)
 * 的时候，会自动帮你生成对应的 fill() 方法
 * <p>
 * 需要告诉 spring
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 判断该字段是否有setter方法
        boolean flag = metaObject.hasSetter("createTime");
        if (flag) {
            System.out.println("insert...");
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 用来判断在更新用户的时候是否用户传值了
        Object val = this.getFieldValByName("updateTime", metaObject);
        if (val == null) {
            System.out.println("update...");
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
