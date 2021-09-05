package me.olle.imagegeneration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImageGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageGenerationApplication.class, args);
	}

}
