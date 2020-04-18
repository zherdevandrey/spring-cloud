package zherdev.tutorial.photoappusersservice;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import zherdev.tutorial.photoappusersservice.shared.FeinErrorDecoder;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PhotoAppUsersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppUsersServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	Logger.Level feinLoggerLevel(){
		return Logger.Level.FULL;
	}

	@Bean
	FeinErrorDecoder feinErrorDecoder(){
		return new FeinErrorDecoder();
	}

}
