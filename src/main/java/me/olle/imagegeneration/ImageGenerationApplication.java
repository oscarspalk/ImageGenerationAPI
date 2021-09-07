package me.olle.imagegeneration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ImageGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageGenerationApplication.class, args);
	}

}
