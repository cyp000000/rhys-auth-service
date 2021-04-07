package za.co.infowarestudios;

import java.io.FileNotFoundException;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
//@Controller
@EnableResourceServer
@EnableDiscoveryClient
public class OauthServiceApplication extends ResourceServerConfigurerAdapter {
	@RequestMapping("/users")
	@ResponseBody
	public Authentication user(Authentication user) {
		return user;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().anonymous().disable().authorizeRequests().antMatchers("/oauth/token/**,/users/login").permitAll();

	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizerQA(@Value("${keystore.file}") String keystoreFile,
			@Value("${keystore.password}") String keystorePassword, @Value("${keystore.type}") String keystoreType
	/* @Value("${keystore.alias}") String keystoreAlias */) throws FileNotFoundException {
		final String absoluteKeystoreFile = "/" + keystoreFile;

		return factory -> {
			TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) factory;
			containerFactory.addConnectorCustomizers((TomcatConnectorCustomizer) (Connector connector) -> {
				connector.setSecure(true);
				connector.setScheme("https");
				connector.setAttribute("keystoreFile", absoluteKeystoreFile);
				connector.setAttribute("keystorePass", keystorePassword);
				connector.setAttribute("keystoreType", keystoreType);
				connector.setAttribute("keystoreProvider", "SunJSSE");
//				connector.setAttribute("keyAlias", keystoreAlias);
				connector.setAttribute("clientAuth", "false");
				connector.setAttribute("sslProtocol", "TLS");
				connector.setAttribute("SSLEnabled", true);

			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(OauthServiceApplication.class, args);
	}

}
