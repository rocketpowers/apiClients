package AccessPackages.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import AccessPackages.model.AccessCredentials;

public interface  AccessCredentialsRepository extends JpaRepository<AccessCredentials, Long > {
	
	
	Optional <AccessCredentials> findByLogin(String login);
}
