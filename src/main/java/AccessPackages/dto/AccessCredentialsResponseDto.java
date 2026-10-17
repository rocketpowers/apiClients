package AccessPackages.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccessCredentialsResponseDto {

	private Long id;
	private String login;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public AccessCredentialsResponseDto(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}
	
	
}
