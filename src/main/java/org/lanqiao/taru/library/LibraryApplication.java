package org.lanqiao.taru.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
public class LibraryApplication {

    private static final Logger logger = LoggerFactory.getLogger(LibraryApplication.class);
    public static void main(String[] args) {
        logger.info("SpringBoot开始加载");
        SpringApplication.run(LibraryApplication.class, args);
        logger.info("SpringBoot加载完毕");
    }

}
