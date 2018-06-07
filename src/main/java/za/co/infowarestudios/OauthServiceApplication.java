package za.co.infowarestudios;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.io.FileNotFoundException;

@SpringBootApplication
@Controller
@EnableResourceServer
@EnableDiscoveryClient
public class OauthServiceApplication {

	@RequestMapping("/user")
	@ResponseBody
	public Authentication user(Authentication user) {
		return user;
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		source.registerCorsConfiguration("/**", config);

		final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

	public EmbeddedServletContainerCustomizer containerCustomizerQA(@Value("${keystore.file}") String keystoreFile,
																																@Value("${keystore.password}") String keystorePassword,
																																@Value("${keystore.type}") String keystoreType,
																																@Value("${keystore.alias}") String keystoreAlias) throws FileNotFoundException
	{
		final String absoluteKeystoreFile = "/"+keystoreFile;

		return factory -> {
			TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) factory;
			containerFactory.addConnectorCustomizers((TomcatConnectorCustomizer) (Connector connector) -> {
				connector.setSecure(true);
				connector.setScheme("https");
				connector.setAttribute("keystoreFile", absoluteKeystoreFile);
				connector.setAttribute("keystorePass", keystorePassword);
				connector.setAttribute("keystoreType", keystoreType);
				connector.setAttribute("keystoreProvider","SunJSSE");
				connector.setAttribute("keyAlias", keystoreAlias);
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
