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

import AccessPackages.model.AccessCredentials;
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
	public AccessCredentials register(@RequestBody AccessCredentials credentials) {
		return accessCredentialsService.saveCredentials(credentials);

	}

	@GetMapping("/credentials")
	public List<AccessCredentials> getCredentials() {
		return accessCredentialsService.getCredentials();
	}

	@PutMapping("/credentials/{id}")
	public AccessCredentials updateCredentials(@PathVariable Long id, @RequestBody AccessCredentials credentials) {
		return accessCredentialsService.updateCredentials(id, credentials);
	}
	@DeleteMapping("/credentials/{id}")
	public String deleteCredentials(@PathVariable Long id) {
		return accessCredentialsService.deleteCredentials(id);
	}

}
