package shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import shorturl.entity.UrlInfo;
import shorturl.service.UrlsManagerService;

@Controller
@RequestMapping("/")
public class RedirectController {
	@Autowired
	UrlsManagerService urlsManagerService;

	@GetMapping("/{shortUrl}")
	public ModelAndView getFullUrl(ModelMap model, @PathVariable String shortUrl) {
		String fullUrl = urlsManagerService.getFullUrl(shortUrl);
		return fullUrl != null ? new ModelAndView("redirect:" + fullUrl, model) : null;
	}
}
