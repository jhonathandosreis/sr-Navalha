package info.datahorizons.authserver.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.security.core.token.Sha512DigestUtils;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserAuth extends BaseEntity{
	
	@Id
	private String login;
	
	@Column(unique=true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	
	private String password;
	
	private String roles;
	
	private String tenant;
	
	private Boolean active = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date passDate = new Date();
	
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private Map<String, Object> extra = new HashMap<String, Object>();

	public void setPasswordRaw(String password) {
		if(password != null) {
			this.password = Sha512DigestUtils.shaHex(password);
		}else {
			throw new AuthException("password required", info.datahorizons.authserver.model.AuthException.Type.PASS_REQUIRED);
		}
	}

	public List<String> getRolesArray() {
		List<String> result = new ArrayList<>();
		if(roles != null) {
			String [] r = roles.split(",");
			for (int i = 0; i < r.length; i++) {
				result.add(r[i].trim().toUpperCase());
			}
		}
		return result;
	}
	
}
