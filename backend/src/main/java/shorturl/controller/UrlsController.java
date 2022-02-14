package shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shorturl.service.UrlsManagerService;

@RestController
@RequestMapping("/api/url")
public class UrlsController {
	@Autowired
	private UrlsManagerService urlsManagerService;

	@PostMapping("/get-short-url")
	public String getShortUrl(@RequestParam("fullUrl") String fullUrl) {
		return urlsManagerService.getShortUrl(fullUrl);
	}
}
