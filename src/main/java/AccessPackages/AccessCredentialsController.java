package AccessPackages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import AccessPackages.dto.AccessCredentialsRequestDto;
import AccessPackages.dto.AccessCredentialsResponseDto;
import AccessPackages.service.AccessCredentialsService;

@RestController
public class AccessCredentialsController {

	@Autowired
	AccessCredentialsService accessCredentialsService;

	@GetMapping("/login")
	public boolean authentication(@RequestParam String login, @RequestParam String password) {

		return accessCredentialsService.authentication(login, password);
	}

	@PostMapping("/register")
	public AccessCredentialsResponseDto register(@RequestBody AccessCredentialsRequestDto dto) {
		return accessCredentialsService.saveCredentials(dto);

	}

	@GetMapping("/credentials")
	public List<AccessCredentialsResponseDto> getCredentials() {
		return accessCredentialsService.getCredentials();
	}

	@PutMapping("/credentials/{id}")
	public AccessCredentialsResponseDto updateCredentials(@PathVariable Long id,
			@RequestBody AccessCredentialsRequestDto dto) {
		return accessCredentialsService.updateCredentials(id, dto);
	}

	@DeleteMapping("/credentials/{id}")
	public String deleteCredentials(@PathVariable Long id) {
		return accessCredentialsService.deleteCredentials(id);
	}

}
