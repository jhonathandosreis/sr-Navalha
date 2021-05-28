package com.fabricasoftware.SrNavalha.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fabricasoftware.SrNavalha.services.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franciscocalaca.http.utils.Token;

@RestController
@RequestMapping(value="/login")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private AuthTokenService tokenBo;

	@PostMapping
	public Map<String, Object> login(@RequestBody Map<String, Object> credential, HttpServletResponse response) {
		Map<String, Object> result = new HashMap();
		Token token = tokenBo.getToken((String) credential.get("user"), (String) credential.get("password"));
		if ("unauthorized".equals(token.getError())) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return result;
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			result.put("tenant", token.getTenant());
			result.put("access_token", token.getAccessToken());
			result.put("error", token.getError());
			result.put("extra", token.getExtra());
			result.put("roles", token.getExtra());
			result.put("login", (String) credential.get("user"));
			result.put("tipo",(String)credential.get("tipo"));
			return result;
		}
	}
}
