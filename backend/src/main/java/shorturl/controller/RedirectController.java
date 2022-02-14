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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class RedirectController {
	@Autowired
	private UrlsManagerService urlsManagerService;

	@GetMapping("/{shortUrl}")
	public void getFullUrl(HttpServletResponse response, @PathVariable String shortUrl) throws IOException {
		String fullUrl = urlsManagerService.getFullUrl(shortUrl);
		response.sendRedirect(fullUrl);
	}
}
