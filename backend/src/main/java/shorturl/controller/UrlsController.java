package shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shorturl.service.UrlsManagerService;

@RestController("/")
public class UrlsController {
	@Autowired
	UrlsManagerService urlsManagerService;

	@PostMapping("/api/url/generate_short_url")
	public String generateShortUrl(@RequestParam("full_url") String fullUrl) {
		return urlsManagerService.generateShortUrl(fullUrl);
	}
}
