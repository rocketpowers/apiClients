package AccessPackages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AccessPackages.model.AccessCredentials;
import AccessPackages.repository.AccessCredentialsRepository;

@Service
public class AccessCredentialsService {

	@Autowired
	private AccessCredentialsRepository accessCredentialsRepository;

	public Boolean authentication(String login, String password) {

		Optional<AccessCredentials> credential = accessCredentialsRepository.findByLogin(login);

		// return credential.isPresent();

		if (credential.isPresent()) {
			return credential.get().getPassword().equals(password);
		}
		return false;

	}

	public AccessCredentials saveCredentials(AccessCredentials credentials) {
		return accessCredentialsRepository.save(credentials);
	}

	public List<AccessCredentials> getCredentials() {
		return accessCredentialsRepository.findAll();
	}

	public AccessCredentials updateCredentials(long id, AccessCredentials newCredentials) {

		Optional<AccessCredentials> credential = accessCredentialsRepository.findById(id);

		if (credential.isPresent()) {

			AccessCredentials existing = credential.get();
			existing.setLogin(newCredentials.getLogin());
			existing.setPassword(newCredentials.getPassword());

			return accessCredentialsRepository.save(existing);
		}
		return null;

	}

	public String deleteCredentials(Long id) {
		accessCredentialsRepository.deleteById(id);
		return "credentials removed successfully";
	}

}
