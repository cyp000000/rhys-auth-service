package za.co.infowarestudios.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import za.co.infowarestudios.dto.LoginRequestDTO;
import za.co.infowarestudios.dto.LoginResponseDTO;
import za.co.infowarestudios.dto.UserLoginResponseVO;
import za.co.infowarestudios.service.LoginService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
	@Autowired
	private LoginService loginService;
	


	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(HttpServletRequest request) throws Exception {
		logger.info("::::: In Generate - token end point :::::");
		String baseUrl = "http://localhost:9099/";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String authHead = request.getHeader("Authorization");
		logger.info("authHead::: " + authHead);
		headers.set("Authorization",
				"Basic " + "dHJ1c3RfY2xpZW50OklEZGpKQkowOVVPYXFCMkJYSEN6MTlCV0p2YUNXUlpDd1dUYm1yZm9qbEU9");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "client_credentials");
		map.add("client_id", "trust_client");
		map.add("username", request.getHeader("username"));
		map.add("password", request.getHeader("password"));
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(null, headers);
		ResponseEntity<LoginResponseDTO> response = null;
		try {
			response = restTemplate.postForEntity(
					"http://185.173.226.118:9091/oauth/token?grant_type=client_credentials&client_id=trust_client", entity,
					LoginResponseDTO.class);

				logger.info("Token is :::" + response.getBody().getAccess_token());
				logger.info("Expire is :::" + response.getBody().getExpires_in());

		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	@RequestMapping(value = "/generate-tokens", method = RequestMethod.POST)
	public ResponseEntity<?> login(LoginRequestDTO requestDto, HttpServletRequest request) throws Exception {

		ResponseEntity responseEntity = null;
		try {
			logger.info("LoggedInUserName ---- {}", requestDto.getEmailAddress());
			UserLoginResponseVO loginResponse = loginService.login(requestDto);

			responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
		}

		catch (Exception ole) {
			logger.error(ole.getMessage(), ole);
		}
		return responseEntity;

	}
}
