package za.co.infowarestudios.service;

import za.co.infowarestudios.dto.LoginRequestDTO;
import za.co.infowarestudios.dto.UserLoginResponseVO;

public interface LoginService {

	UserLoginResponseVO login(LoginRequestDTO loginRequest) throws Exception;

}
