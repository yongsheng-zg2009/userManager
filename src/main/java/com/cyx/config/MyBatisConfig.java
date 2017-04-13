package com.cyx.config;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.pagehelper.PageHelper;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 注册MyBatis分页插件PageHelper
 *
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */

@Configuration
@MapperScan("com.cyx.dao")
public class MyBatisConfig {
    @Autowired
    private Environment env;
        @Bean
       //@Primary
       public DataSource getDataSource() throws Exception{
          Properties props = new Properties();
          props.put("driverClassName", env.getProperty("spring.datasource.driver-class-name"));
          props.put("url", env.getProperty("spring.datasource.url"));
          props.put("username", env.getProperty("spring.datasource.username"));
          props.put("password", env.getProperty("spring.datasource.password"));
          return DruidDataSourceFactory.createDataSource(props);
    }
    @Bean
     public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
              SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
                fb.setDataSource(ds);//指定数据源(这个必须有，否则报错)
                //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
                  fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));//指定基包
                 fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//指定xml文件位置
                 return fb.getObject();
         }
    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}


