package com.dlsu.lrs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.AcademicType;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.repo.AcademicRepository;
import com.dlsu.lrs.repo.AccountRepository;

@EntityScan(basePackageClasses = {SecurdeLrsApplication.class, Jsr310JpaConverters.class})
@SpringBootApplication
public class SecurdeLrsApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurdeLrsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecurdeLrsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AcademicRepository acad, AccountRepository acc) {
		return args -> {

			acad.save(new Academic("11415959", "Jose", "Romabiles", "Ople"));
			acad.save(new Academic("11515959", "Jaena", "Roma", "People"));
			acad.save(new Academic("9945982347", "Maria", "Si", "Nukuan", AcademicType.FACULTY));
			
//			LOG.info("-----------------------");
//			LOG.info("Perform: acad.findAll()");
//			for(Academic a : acad.findAll())
//				LOG.info(a.toString());

			acc.save(new Account("paxromana", acad.findOne("11415959"), "SolitaryKnife", "123456789"));
			acc.save(new Account("aromana", acad.findOne("11415959"), "SolitaryKnife2", "123456789"));
		
			LOG.info("-----------------------");
			LOG.info("Perform: acad.findAll()");
			for(Academic a : acad.findAll())
				LOG.info(a.toString());
		};
	}
}
