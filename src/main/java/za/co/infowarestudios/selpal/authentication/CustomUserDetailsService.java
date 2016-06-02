/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.infowarestudios.selpal.authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.co.infowarestudios.selpal.entity.AuthenticateUser;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	public AuthenticationService authenticationService;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		AuthenticateUser authenticateUser = authenticationService.authenticateUser(userId);
		if (authenticateUser == null) {
			throw new UsernameNotFoundException(String.format("AuthenticateUser %s does not exist!", userId));
		}

		return new MobileAppAuthenticateUserDetails(authenticateUser);
	}

	public final static class MobileAppAuthenticateUserDetails extends AuthenticateUser implements UserDetails {

		private static final long serialVersionUID = 1L;

		public MobileAppAuthenticateUserDetails(AuthenticateUser authenticateUser) {
			super(authenticateUser);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("TRUSTED_MOBILE"));
			switch ((int)super.getRole()){
				case 1:	authorities.add(new SimpleGrantedAuthority("TRUSTED_MERCHANT"));
					break;
				case 2: authorities.add(new SimpleGrantedAuthority("TRUSTED_OPERATOR"));
					break;
//				case 3: authorities.add(new SimpleGrantedAuthority("TRUSTED_MOBILE"));
//					break;
				case 4: authorities.add(new SimpleGrantedAuthority("TRUSTED_CUSTOMER"));
					break;
				case 5: authorities.add(new SimpleGrantedAuthority("TRUSTED_FIELD_USER"));
					break;
			}
			return authorities;
		}

		@Override
		public String getUsername() {
			return getLogin();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
