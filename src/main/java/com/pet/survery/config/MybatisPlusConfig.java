package com.pet.survery.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus 配置类文件
 *
 * @author zbwdesigner
 * @since 2020/02/01 10:05
 */
//开启统一事务管理注解
@EnableTransactionManagement
@Configuration
@MapperScan({
        "com.pet.survery.investigate.mapper"
})
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
