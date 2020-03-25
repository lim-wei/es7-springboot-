package com.liaoyuan.dianping.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对管理员进行权限控制的切面
 * ：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、
 * 方法参数和本地变量（如循环变量、catch参数）
 * Created by limw on 2020/3/12.
 */
@Target({ElementType.METHOD})    //说明了Annotation所修饰的对象范围,在Annotation类型的声明中使用了target可更加明晰其修饰的目标。
@Retention(RetentionPolicy.RUNTIME)    // @Retention定义了该Annotation被保留的时间长短,RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
public @interface AdminPermission {
    String produceType() default "text/html";
}
