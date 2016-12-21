package com.tngtech.jgiven.integration.spring.test.proxy;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableJGiven
@ComponentScan( basePackages = "com.tngtech.jgiven.integration.spring.test.proxy" )
@Import(TestAspect.class)
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ProxyTestConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().build();
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
