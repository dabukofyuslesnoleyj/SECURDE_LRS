package com.dlsu.lrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.AcademicType;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountSecurity;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.repos.AcademicRepository;
import com.dlsu.lrs.repos.AccountRepository;

@SpringBootApplication
public class SecurdeLrsApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurdeLrsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecurdeLrsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AcademicRepository acad, AccountRepository acc) {
		return args -> {
			
			Academic a = new Academic("11415959", "Jose", "Romabiles", "Ople", AcademicType.STAFF);
			acad.save(a);
			
			Account b = new Account(AccountType.ADMIN + a.getId(), "SK", "1234", a, new AccountSecurity("All for One", "One for All"), AccountType.ADMIN);
			acc.save(b);

			LOG.info("--------------------------------------");
			LOG.info("--------------------------------------");
			for(Academic e : acad.findAll())
				System.out.println(e.getFirstName() + " " + e.getLastName());
			LOG.info("--------------------------------------");
			for(Account e : acc.findAll())
				System.out.println(e.getUsername() + " : " + e.getPassword());

			LOG.info("--------------------------------------");
			LOG.info("--------------------------------------");
		};
	}
}
