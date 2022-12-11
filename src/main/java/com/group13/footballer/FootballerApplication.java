package com.group13.footballer;

import com.group13.footballer.Config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class FootballerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballerApplication.class, args);
	}

}
@RestController
class HelloController{
	@GetMapping("/")
	String Hello(){
		return "Welcome to footballer API \n " +
				"Made By \n " +
				"Ali Han Özdoğan \n 																																										" +
				"Koray Kahraman \n " +
				"Onur Hanife \n " +
				"Sıddık Can Dağdeviren \n " +
				"Mechmet Chotzoglou Chalil \n\n\n";
	}
}
