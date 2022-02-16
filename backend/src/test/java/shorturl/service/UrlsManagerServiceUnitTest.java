package shorturl.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UrlsManagerServiceUnitTest {

    private UrlsManagerService urlsManagerService = new UrlsManagerService();

    @Test
    public void validateUrl_whenCorrectUrl() {
        Assertions.assertTrue(urlsManagerService.validateUrl("https://google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("https://www.google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("http://google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("http://www.google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("www.google.com"));
        Assertions.assertTrue(urlsManagerService.validateUrl("https://www.google.com/search?client=firefox-b-d&q=test"));
        Assertions.assertTrue(urlsManagerService.validateUrl("https://google.com/search?client=firefox-b-d&q=test"));
        Assertions.assertTrue(urlsManagerService.validateUrl("google.com/search?client=firefox-b-d&q=test"));
    }

    @Test
    public void validateUrl_whenIncorrectUrl() {
        Assertions.assertFalse(urlsManagerService.validateUrl("httpsd://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("htts://www.google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("htto://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("httpshttp://www.google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("httphttps://www.google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("httphttp://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("httpshttps://www.google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("http//http://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("http://http://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https//google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https/google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https:/google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https:google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https://go$ogle.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https://go&ogle.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("https://go?ogle.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("www.https://google.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("www.google.https://"));
        Assertions.assertFalse(urlsManagerService.validateUrl("www.google.https://.com"));
        Assertions.assertFalse(urlsManagerService.validateUrl("google.https://.com"));
    }
}