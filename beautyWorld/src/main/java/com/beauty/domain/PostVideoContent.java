/**
 * 
 */
package main.java.com.beauty.domain;

/**
 * @author vinay
 * 
 */
public class PostVideoContent {

	private Long postVidId;
	private Posts posts;
	private String postVideoUrl;
	private String postVideoDescription;

	public Long getPostVidId() {
		return postVidId;
	}

	public void setPostVidId(Long postVidId) {
		this.postVidId = postVidId;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public String getPostVideoUrl() {
		return postVideoUrl;
	}

	public void setPostVideoUrl(String postVideoUrl) {
		this.postVideoUrl = postVideoUrl;
	}

	public String getPostVideoDescription() {
		return postVideoDescription;
	}

	public void setPostVideoDescription(String postVideoDescription) {
		this.postVideoDescription = postVideoDescription;
	}

}
