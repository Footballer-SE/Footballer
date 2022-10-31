package com.group13.footballer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
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
