package com.liaoyuan.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.liaoyuan.dianping"})
@MapperScan("com.liaoyuan.dianping.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true) // springboot容器可以开始解析aop的一些设置
public class DianpingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DianpingApplication.class, args);
	}

}
