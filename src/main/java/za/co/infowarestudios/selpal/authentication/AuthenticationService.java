package za.co.infowarestudios.selpal.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.infowarestudios.selpal.entity.AuthenticateUser;
import za.co.infowarestudios.selpal.entity.User;
import za.co.infowarestudios.selpal.repositories.UserRepository;

/**
 * Created by victorrikhotso on 2016/01/29.
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
		User user = userRepository.findUserByUserId(userId);
		AuthenticateUser authenticateUser = new AuthenticateUser(user.getUserId(),user.getUserId(),user.getPin());
		authenticateUser.setRole(user.getRole().getId());
		return authenticateUser;
	}

}
