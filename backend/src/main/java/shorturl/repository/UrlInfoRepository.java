package shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shorturl.entity.UrlInfo;

import java.util.Optional;

@Repository
public interface UrlInfoRepository extends JpaRepository<UrlInfo, String> {
	@Query
	Optional<UrlInfo> getByShortUrl(String shortUrl);
}
