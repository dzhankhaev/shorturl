package shorturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shorturl.entity.UrlInfo;
import shorturl.repository.UrlInfoRepository;

import java.sql.Timestamp;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class UrlsManagerService {
	@Autowired
	private UrlInfoRepository urlInfoRepository;

	public boolean validateUrl(String fullUrl) {
		String regex = fullUrl.contains("://") ? "^(https|http)://[-a-zA-Z0-9]*\\.[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*"
				: "^[-a-zA-Z0-9]*\\.[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*";
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(fullUrl);
			return matcher.matches();
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	private String generateShortUrl() {
		Random random = new Random();
		return random.ints('a', 'z' + 1)
				.limit(5)	//длина
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
	public String getShortUrl(String fullUrl) {
		if (!validateUrl(fullUrl))
			return null;
		String shortUrl = generateShortUrl();
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
