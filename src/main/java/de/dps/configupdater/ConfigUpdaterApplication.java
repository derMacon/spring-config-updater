package de.dps.configupdater;

import de.dps.configupdater.config.MockConfig;
import de.dps.configupdater.config.RandomObjList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ConfigUpdaterApplication {
//	public class ConfigUpdaterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConfigUpdaterApplication.class, args);
	}

	@Autowired
	private MockConfig mockConfig;

	@Autowired
	private RandomObjList randomObjList;

//	@Override
//	public void run(String... args) throws Exception {
//		log.info("hiho");
//		log.info(mockConfig.toString());
//	}
}
