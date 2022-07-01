package com.five.auth.сontroller;

import com.five.auth.model.authorities.Role;
import com.five.auth.model.User;
import com.five.auth.model.dto.AuthenticationDTO;
import com.five.auth.model.dto.RegisteredDto;
import com.five.auth.model.dto.RegistrationDto;
import com.five.auth.service.UserService;
import com.five.auth.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

	@Autowired
	private JwtUtil jwtUtil;

	private final UserService userService;
	private final ModelMapper modelMapper;
	private final AuthenticationManager authenticationManager;


	public AuthController(UserService userService, ModelMapper modelMapper, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/auth/login")
	public ResponseEntity<Map<Object,Object>> login(@RequestBody AuthenticationDTO request) {

	authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = userService.findByEmail(request.getEmail());
		String token = jwtUtil.generateToken(request.getEmail(), user.getRole());

		Map<Object, Object> response = new HashMap<>();
		response.put("email", request.getEmail());
		response.put("token", token);
		return ResponseEntity.ok(response);

	}

	@PostMapping("/auth/register")
	public ResponseEntity<RegisteredDto> register(@Valid @RequestBody RegistrationDto registrationDto) {
		User savedUser = userService.register(modelMapper.map(registrationDto, User.class), Role.USER);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(modelMapper.map(savedUser, RegisteredDto.class));
	}

}
