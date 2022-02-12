package shorturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shorturl.entity.UrlInfo;
import shorturl.repository.UrlInfoRepository;

import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;

@Service
public class UrlsManagerService {
	@Autowired
	UrlInfoRepository urlInfoRepository;

	public String generateShortUrl(String fullUrl) {
		Random random = new Random();
		String shortUrl = random.ints('a', 'z' + 1)
				.limit(5)	//длина
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		urlInfoRepository.save(new UrlInfo(shortUrl, fullUrl, time, time, 0, 0));
		return shortUrl;
	}

	public String getFullUrl(String shortUrl) {
		UrlInfo urlInfo = urlInfoRepository.getByShortUrl(shortUrl).orElse(null);
		if (urlInfo == null)
			return null;
		urlInfo.setLastUsedDate(new Timestamp(System.currentTimeMillis()));
		urlInfo.setClick_count(urlInfo.getClick_count() + 1);
		urlInfoRepository.save(urlInfo);
		return urlInfo.getFullUrl();
	}
}
