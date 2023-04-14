package rf.com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PbpTienda2023Application {

	public static void main(String[] args) {
		SpringApplication.run(PbpTienda2023Application.class, args);
	}

}
