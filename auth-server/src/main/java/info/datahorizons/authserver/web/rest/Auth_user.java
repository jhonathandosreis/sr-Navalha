package info.datahorizons.authserver.web.rest;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.datahorizons.authserver.dto.User;
import info.datahorizons.authserver.model.AuthException;
import info.datahorizons.authserver.model.UserAuth;
import info.datahorizons.authserver.model.AuthException.Type;
import info.datahorizons.authserver.persistence.UserAuthDao;
import info.datahorizons.authserver.persistence.UserAuthDaoExtra;

@RestController
@CrossOrigin("*")
@RequestMapping("/tokens")
public class Auth_user {
	
	@Autowired
	private UserAuthDaoExtra userAuthDao;

	@PostMapping
	public UserAuth saveUser(@RequestBody UserAuth user, Principal principal) {
		Optional<UserAuth> opt = userAuthDao.findById(user.getLogin().toLowerCase());
		if (opt.isPresent()) {
			throw new AuthException(String.format("%s already exists", user.getLogin()), Type.EMAIL_ALREADY_EXISTS);
		}
		
		UserAuth userAuth = new UserAuth();
		userAuth.setPasswordRaw(user.getPassword());
		userAuth.setLogin(user.getLogin().toLowerCase());
		userAuth.setEmail(user.getLogin().toLowerCase());
		userAuth.getExtra().putAll(user.getExtra());
		StringBuffer roles = new StringBuffer();
		boolean first = true;

		userAuth.setTenant(user.getTenant());
		return userAuthDao.save(userAuth);
	}
}
