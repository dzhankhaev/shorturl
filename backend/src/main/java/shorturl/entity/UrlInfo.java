package shorturl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "urls_info", schema = "shorturl")
public class UrlInfo {
	@Id
	@Column(name = "short_url", nullable = false)
	private String shortUrl;
	@Column(name = "full_url", nullable = false)
	private String fullUrl;
	@Column(name = "created_date", nullable = false)
	private Timestamp createdDate;
	@Column(name = "last_used_date", nullable = false)
	private Timestamp lastUsedDate;
	@Column(name = "life_time")
	private long life_time;
	@Column(name = "click_count")
	private long click_count;

	public UrlInfo() {
	}

	public UrlInfo(String shortUrl, String fullUrl, Timestamp createdDate, Timestamp lastUsedDate,
				   long life_time, long click_count) {
		this.shortUrl = shortUrl;
		this.fullUrl = fullUrl;
		this.shortUrl = shortUrl;
		this.createdDate = createdDate;
		this.lastUsedDate = lastUsedDate;
		this.life_time = life_time;
		this.click_count = click_count;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastUsedDate() {
		return lastUsedDate;
	}

	public void setLastUsedDate(Timestamp lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	public long getLife_time() {
		return life_time;
	}

	public void setLife_time(long life_time) {
		this.life_time = life_time;
	}

	public long getClick_count() {
		return click_count;
	}

	public void setClick_count(long click_count) {
		this.click_count = click_count;
	}
}
