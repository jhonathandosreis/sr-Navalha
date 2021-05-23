package info.datahorizons.authserver.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.datahorizons.authserver.model.UserAuth;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

	@EqualsAndHashCode.Include
	private String login;

	private Map<String, Object> extra = new HashMap<>();

	private String password;

	private List<String> roles = new ArrayList<String>();

	@EqualsAndHashCode.Include
	private String tenant;

	public User(UserAuth userAuth) {
		this.login = userAuth.getLogin();
		this.extra = userAuth.getExtra();
		this.roles = userAuth.getRolesArray();
		this.tenant = userAuth.getTenant();
		this.roles.remove("ROLE_ADMIN");
		this.roles.remove("ADMIN");
	}

}
