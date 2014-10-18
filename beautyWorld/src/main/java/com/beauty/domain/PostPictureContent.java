/**
 * 
 */
package main.java.com.beauty.domain;

/**
 * @author vinay
 * 
 */
public class PostPictureContent {

	private Long postPicId;
	private Posts posts;
	private String postPicture;
	private String postPictureDescription;

	public PostPictureContent() {
		super();
	}

	public Long getPostPicId() {
		return postPicId;
	}

	public void setPostPicId(Long postPicId) {
		this.postPicId = postPicId;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public String getPostPicture() {
		return postPicture;
	}

	public void setPostPicture(String postPicture) {
		this.postPicture = postPicture;
	}

	public String getPostPictureDescription() {
		return postPictureDescription;
	}

	public void setPostPictureDescription(String postPictureDescription) {
		this.postPictureDescription = postPictureDescription;
	}

}
