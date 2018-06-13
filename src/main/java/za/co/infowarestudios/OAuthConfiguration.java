package za.co.infowarestudios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import za.co.infowarestudios.authentication.CustomUserDetailsService;


@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer)
					throws Exception {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	@Bean
	public DefaultAccessTokenConverter defaultAccessTokenConverter() {
		return new DefaultAccessTokenConverter();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
						.authenticationManager(this.authenticationManager)
						.userDetailsService(userDetailsService)
						.accessTokenConverter(defaultAccessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("trust_client")
				.resourceIds(new String[] {"user_api","product_api","transaction_api","notification_api"})
				.authorities("TRUSTED_CLIENT")
				.scopes("login","read","register","shop","reset_password","deposit","transfer","notifications")
				.authorizedGrantTypes("password","refresh_token","implicit","client_credentials")
				.secret("IDdjJBJ09UOaqB2BXHCz19BWJvaCWRZCwWTbmrfojlE=")
				.accessTokenValiditySeconds(60*10080)     //Valid for one week
				.refreshTokenValiditySeconds(60*60*24)
				.and();
	}
}
