package com.springmongo.springbootmongodbcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootMongodbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbCrudApplication.class, args);
	}

}
