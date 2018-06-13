package za.co.infowarestudios.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.infowarestudios.entity.User;
import za.co.infowarestudios.repositories.UserRepository;
import za.co.infowarestudios.entity.AuthenticateUser;

/**
 * Created by Jomo Lumina on 2018/06/05.
 */
@Service
public class AuthenticationService {

	/**
	 * Send the request to the user-management service to authentiate the actual user
	 * @param userId
	 * @return user
	 */
	@Autowired
	private UserRepository userRepository;

	public AuthenticateUser authenticateUser(final String userId){
		// Find the user
		User user = userRepository.findByUserId(userId);
		AuthenticateUser authenticateUser = new AuthenticateUser(user.getUserId(),user.getUserId(),user.getPassword());
		authenticateUser.setRole(user.getRole().getId());
		return authenticateUser;
	}

}
