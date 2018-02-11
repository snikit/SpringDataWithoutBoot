package me.snikit;

import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@Configuration("mainBean")
@EnableJpaRepositories(basePackages = "me.snikit")
@Import(JpaConfig.class)
@Transactional
public class AppInit {
	private static final Logger log = LoggerFactory.getLogger(AppInit.class);

	@Autowired
	private CustomerRepo repository;

	public static void main(String[] args) throws URISyntaxException, Exception {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppInit.class);
		ctx.refresh();

		
		System.out.println("Load context");
		AppInit s = (AppInit) ctx.getBean("mainBean");

	
	}
}