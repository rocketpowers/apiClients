package AccessPackages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AccessPackages.dto.AccessCredentialsRequestDto;
import AccessPackages.dto.AccessCredentialsResponseDto;
import AccessPackages.model.AccessCredentials;
import AccessPackages.repository.AccessCredentialsRepository;

@Service
public class AccessCredentialsService {

	@Autowired
	private AccessCredentialsRepository accessCredentialsRepository;

	public Boolean authentication(String login, String password) {

		Optional<AccessCredentials> credential = accessCredentialsRepository.findByLogin(login);

		return credential.isPresent() && credential.get().getPassword().equals(password);
	}
	

	public AccessCredentialsResponseDto saveCredentials(AccessCredentialsRequestDto dto) {
		AccessCredentials credentials = new AccessCredentials();
		credentials.setLogin(dto.getLogin());
		credentials.setPassword(dto.getPassword());

		AccessCredentials saved = accessCredentialsRepository.save(credentials);

		return new AccessCredentialsResponseDto(saved.getId(), saved.getLogin());
	}

	public List<AccessCredentialsResponseDto> getCredentials() {
		List<AccessCredentialsResponseDto> response = new ArrayList<>();
		for (AccessCredentials credentials : accessCredentialsRepository.findAll()) {
			response.add(new AccessCredentialsResponseDto(credentials.getId(), credentials.getLogin()));
		}
		return response;
	}

	public AccessCredentialsResponseDto updateCredentials(Long id, AccessCredentialsRequestDto dto) {

		Optional<AccessCredentials> credential = accessCredentialsRepository.findById(id);

		if (credential.isEmpty()) {

			return null;

		}

		AccessCredentials existing = credential.get();
		existing.setLogin(dto.getLogin());
		existing.setPassword(dto.getPassword());

		AccessCredentials updated = accessCredentialsRepository.save(existing);

		return new AccessCredentialsResponseDto(updated.getId(), updated.getLogin());
	}

	public String deleteCredentials(Long id) {
		accessCredentialsRepository.deleteById(id);
		return "credentials removed successfully";
	}

}
