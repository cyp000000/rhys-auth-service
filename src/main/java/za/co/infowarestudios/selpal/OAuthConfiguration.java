package za.co.infowarestudios.selpal;

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
import za.co.infowarestudios.selpal.authentication.CustomUserDetailsService;


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
				.withClient("trust_service")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api","transactions_api"})
				.authorities("TRUSTED_SERVICE")
				.scopes("login","read","register","balances","shop")
				.authorizedGrantTypes("client_credentials")
				.secret("SBw3HbZAjnmOy5Dl9Ax8LD79srQHKaFrJRhFe0PF+bY=")
				.accessTokenValiditySeconds(60*2)    // 2 minutes
				.and()
				.withClient("trust_mobile")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api","lotto_star_api"})
				.authorities("TRUSTED_MOBILE")
				.scopes("login","read","register","balances","shop")
				.authorizedGrantTypes("password","refresh_token","implicit")
				.secret("knownuser")
				.accessTokenValiditySeconds(60*30)        // 10 minutes
				.refreshTokenValiditySeconds(60*60*24)   // 24 hours (a new refresh token will need to be requested after 24 hours)
				.and()
				.withClient("any_mobile_user")                   // Client that allows mobile user to check login details (must be initialized)
				.resourceIds("user_api")
				.authorities("UNKNOWN_MOBILE")
				.scopes("login","read","reset_password","shop")
				.authorizedGrantTypes("client_credentials")
				.secret("anyuser")
				.accessTokenValiditySeconds(60*30)
				.and()
				.withClient("trust_mobile_transact")
				.authorities("TRUSTED_MOBILE_TRANSACT")
				.resourceIds("transactions_api", "user_api", "store_api", "lotto_star_api")
				.scopes("deposit","transfer","checkout", "get_merchant", "get_store", "read")
				.authorizedGrantTypes("password")
				.secret("4DhAMiaeU730GGA5mwyOOCjgY8O2GzeJMVI8kqVeuXc")
				.accessTokenValiditySeconds(60*30)
		    .and() // LOTTO STAR
				.withClient("lotto_star_client")
				.authorities("TRUSTED_LOTTO_STAR")
				.resourceIds("lotto_star_api", "user_api")
				.scopes("withdrawal", "read")
				.authorizedGrantTypes("client_credentials")
				.secret("lCW81+JSiRb12tHWJyGas4BLvYjfNwJg3xV6wH3wZy8=")
				.accessTokenValiditySeconds(60*2)
				.and() // USSD
				.withClient("ussd_client")
				.authorities("TRUSTED_USSD")
				.resourceIds("user_api","ussd_api", "wallet_balances_api", "lotto_star_api")
				.scopes("read", "checkout")
				.authorizedGrantTypes("client_credentials","refresh_token")
				.secret("gfwZqIf1gA8LSz8tFUn2QvC5sBHU3EDBjdt5oWX99c8=")
				.accessTokenValiditySeconds(60*60)
				.refreshTokenValiditySeconds(60*10)
				.and()
				.withClient("trust_web_admin")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api","transactions_api"})
				.authorities("TRUSTED_WEB_ADMIN")
				.scopes("login","read","register","balances","shop","deactivate_operator", "activate_operator")
				.authorizedGrantTypes("client_credentials")
				.secret("selpal-admin")
				.accessTokenValiditySeconds(60*30)
				.and()
				.withClient("trust_merchant")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api", "lotto_star_api"})
				.authorities(new String[] {"TRUSTED_MERCHANT","TRUSTED_MOBILE"})
				.scopes(new String[] {"login","read","register","balances","shop","get_all_operators","deactivate_operator","activate_operator"})
				.authorizedGrantTypes("password","refresh_token","implicit")
				.secret("AqSZpMlChzUMs5mLS8IPShyOrYmo4TAKpcOVaCzvEsI=")
				.accessTokenValiditySeconds(60*30)
				.refreshTokenValiditySeconds(60*60*24)
				.and()
				.withClient("trust_operator")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api", "lotto_star_api"})
				.authorities(new String[] {"TRUSTED_OPERATOR","TRUSTED_MOBILE"})
				.scopes(new String[] {"login","read","register","balances","shop"})
				.authorizedGrantTypes("password","refresh_token","implicit")
				.secret("vXJXY5nhigMurGXuUhGR8WvcRMRKdXmf1dJsd7hP5T0=")
				.accessTokenValiditySeconds(60*30)
				.refreshTokenValiditySeconds(60*60*24)
				.and()
				.withClient("trust_customer")
				.resourceIds(new String[] {"user_api","wallet_balances_api","shop_api", "lotto_star_api"})
				.authorities(new String[] {"TRUSTED_CUSTOMER","TRUSTED_MOBILE"})
				.scopes(new String[] {"login","read","register","balances","shop"})
				.authorizedGrantTypes("password","refresh_token","implicit")
				.secret("IDdjJBJ09UOaqB2BXHCz19BWJvaCWRZCwWTbmrfojlE=")
				.accessTokenValiditySeconds(60*30)
				.refreshTokenValiditySeconds(60*60*24)
				.and()
				.withClient("trust_merchant_deposit")
				.resourceIds(new String[] {"user_api","store_api","transactions_api"})
				.authorities("TRUSTED_WEB_ADMIN_DEPOSIT")
				.scopes("merchant_deposit")
				.authorizedGrantTypes("client_credentials")
				.secret("pkWbQJL2lWoprBeNZmgRp9prKyr3frDqRSBJVwCgFBg=")
				.accessTokenValiditySeconds(60*5)
				.and()
				//Below token is an all access token. TODO: Introduce proper token handling
				.withClient("trust_client")
				.resourceIds(new String[] {"user_api","store_api","wallet_balances_api","shop_api","transactions_api","ussd_api","lotto_star_api"})
				.authorities("TRUSTED_CLIENT")
				.scopes("login","read","register","balances","shop","get_all_operators","deactivate_operator","activate_operator","checkout","withdrawal","reset_password","deposit","transfer","get_merchant","get_store")
				.authorizedGrantTypes("password","refresh_token","implicit","client_credentials")
				.secret("IDdjJBJ09UOaqB2BXHCz19BWJvaCWRZCwWTbmrfojlE=")
				.accessTokenValiditySeconds(60*10080)     //Valid for one week
				.refreshTokenValiditySeconds(60*60*24)
				.and();
	}
}
