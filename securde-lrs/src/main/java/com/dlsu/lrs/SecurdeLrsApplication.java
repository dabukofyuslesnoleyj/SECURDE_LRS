package com.dlsu.lrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.AcademicType;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountSecurity;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.repos.AcademicRepository;
import com.dlsu.lrs.repos.AccountRepository;

@SpringBootApplication
public class SecurdeLrsApplication extends SpringBootServletInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(SecurdeLrsApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SecurdeLrsApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecurdeLrsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AcademicRepository acad, AccountRepository acc) {
		return args -> {

			Academic a = new Academic("11415959", "Jose", "Romabiles", "Ople", AcademicType.STAFF);
			acad.save(a);
			Academic b = new Academic();
			b.setId("111");
			b.setType(AcademicType.FACULTY);
			acad.save(b);
			
			Account c = new Account(AccountType.ADMIN + a.getId(), "SK", "1234", a, new AccountSecurity("All for One", "One for All"), AccountType.ADMIN);
			acc.save(c);

		};
	}
}
