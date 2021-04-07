package za.co.infowarestudios.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.infowarestudios.dto.LoginRequestDTO;
import za.co.infowarestudios.dto.Profile;
import za.co.infowarestudios.dto.Role;
import za.co.infowarestudios.dto.UserLoginResponseVO;
import za.co.infowarestudios.entity.Administrator;
import za.co.infowarestudios.entity.User;
import za.co.infowarestudios.repositories.AdministratorRepository;
import za.co.infowarestudios.repositories.UserRepository;

@Service
public class LoginServiceImpl implements za.co.infowarestudios.service.LoginService {

	@Autowired
	private UserRepository userAccountRepo;
	@Autowired
	private AdministratorRepository adminRepo;

	@Override
	public UserLoginResponseVO login(LoginRequestDTO loginRequest) throws Exception {
		UserLoginResponseVO response = new UserLoginResponseVO();
		Optional<User> userAccountResponse = userAccountRepo.findByEmailAddress(loginRequest.getEmailAddress());
		if (userAccountResponse.isPresent()) {
			if (userAccountResponse.get().getRoleBean().getId() == 1) {
				Optional<Administrator> adminDetailsResponseVo = adminRepo
						.findByUserId(userAccountResponse.get().getUserId());
				if (adminDetailsResponseVo.isPresent()) {
					Profile profile = new Profile();
					profile.setUserId(adminDetailsResponseVo.get().getUserId());
					profile.setName(adminDetailsResponseVo.get().getName());
					profile.setPhoneNumber(adminDetailsResponseVo.get().getPhoneNumber());
					profile.setEmailAddress(adminDetailsResponseVo.get().getEmailAddress());
					profile.setCreated(adminDetailsResponseVo.get().getCreated().toString());
					if (adminDetailsResponseVo.get().getActive() == 1) {
						profile.setActive(true);
					} else
						profile.setActive(false);
					response.setProfile(profile);
				} else {
					throw new Exception("Admin profile record not found");
				}
			}

			za.co.infowarestudios.dto.User user = new za.co.infowarestudios.dto.User();
			Role role = new Role();
			user.setUserId(userAccountResponse.get().getUserId());
			user.setEmailAddress(userAccountResponse.get().getEmailAddress());
			user.setCreated(userAccountResponse.get().getCreated().toString());
			if (userAccountResponse.get().getFirstTimeLoggedIn() == 1)
				user.setFirstTimeLoggedIn(true);
			else
				user.setFirstTimeLoggedIn(false);
			if (userAccountResponse.get().getActive() == 1) {
				user.setActive(true);
				role.setActive(true);
			} else {
				user.setActive(false);
				role.setActive(false);
			}
			role.setDescription(userAccountResponse.get().getRoleBean().getDescription());
			role.setUserId(userAccountResponse.get().getUserId());
			user.setRole(role);
			response.setUser(user);
			return response;

		} else {
			throw new Exception("No record found against user account !!");
		}

	}

}
