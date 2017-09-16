package com.chcit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication  extends SpringBootServletInitializer
{
	@Autowired
	DataSource dataSource;

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(ServiceApplication.class);
	}

	public static void main( String[] args )
	{
		new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);
	}
}
