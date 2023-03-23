package com.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author relief
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//路径必须与mapper文件在的路径一致，否则依然会报错
@MapperScan(value = "com.train.**.mapper")
public class TrainModelingApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(TrainModelingApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Train Modeling启动成功   ლ(´ڡ`ლ)ﾞ ");
    }
}
