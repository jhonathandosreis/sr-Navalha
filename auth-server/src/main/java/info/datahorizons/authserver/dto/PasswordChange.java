package info.datahorizons.authserver.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PasswordChange {

	@EqualsAndHashCode.Include
	private String login;

	@EqualsAndHashCode.Include
	private String actual;

	@EqualsAndHashCode.Include
	private String newPass;

}
