package info.datahorizons.authserver.web.rest;

import java.security.Principal;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.datahorizons.authserver.dto.User;
import info.datahorizons.authserver.model.UserAuth;
import info.datahorizons.authserver.persistence.UserAuthDaoExtra;

@RestController
@RequestMapping("/tokens")
public class Auth_user {
	@Autowired
	private UserAuthDaoExtra userAuthDao;

	@PostMapping
	public Object saveUser(@RequestBody User user, Principal principal) {
		Optional<UserAuth> admin = userAuthDao.findById(principal.getName());
		UserAuth userAuth = new UserAuth();
		userAuth.setPasswordRaw(user.getPassword());
		userAuth.setLogin(user.getLogin().toLowerCase());
		userAuth.setEmail(user.getLogin().toLowerCase());
		userAuth.getExtra().putAll(user.getExtra());
		StringBuffer roles = new StringBuffer();
		boolean first = true;
		for (String s : user.getRoles()) {
			if (!first) {
				roles.append(",");
			}
			roles.append(s.toUpperCase());
		}
		userAuth.setRoles(roles.toString().toLowerCase());
		userAuth.setTenant(user.getTenant());

		return userAuthDao.save(userAuth);
	}
}
