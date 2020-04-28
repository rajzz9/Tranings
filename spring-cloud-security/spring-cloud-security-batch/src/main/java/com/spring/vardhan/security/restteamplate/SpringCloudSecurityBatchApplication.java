package com.spring.vardhan.security.restteamplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudSecurityBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityBatchApplication.class, args);
	}
	
	@Bean
	public BatchSecurity batchSecurity() {
		return new BatchSecurity();
	}
	
	class BatchSecurity implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
			resource.setAccessTokenUri("http://localhost:9000/service/oauth/token");
			resource.setClientId("rajzz9");
			resource.setClientSecret("test");
			resource.setGrantType("password");
			resource.setUsername("allen");
			resource.setPassword("password1");
			resource.setClientAuthenticationScheme(AuthenticationScheme.header);
			OAuth2RestTemplate tempalte = new OAuth2RestTemplate(resource);
			String results = tempalte.getForObject("http://localhost:8000/resource/account", String.class);
			System.out.println("results : "+ results);
		}

	}
}
