/**
 * 
 */
package main.java.com.beauty.domain;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author vinay
 * 
 */
public class PostPictureContent implements Comparable<PostPictureContent> {

	private Long postPicId;
	private Posts posts;
	private String postPicture;
	private String postPictureDescription;
	private String postPicVideoUrl;
	private String postPicVideoDesc;

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
		return StringEscapeUtils.unescapeHtml(postPictureDescription);
	}

	public void setPostPictureDescription(String postPictureDescription) {
		this.postPictureDescription = postPictureDescription;
	}

	public String getPostPicVideoUrl() {
		return postPicVideoUrl;
	}

	public void setPostPicVideoUrl(String postPicVideoUrl) {
		this.postPicVideoUrl = postPicVideoUrl;
	}

	public String getPostPicVideoDesc() {
		return StringEscapeUtils.unescapeHtml(postPicVideoDesc);
	}

	public void setPostPicVideoDesc(String postPicVideoDesc) {
		this.postPicVideoDesc = postPicVideoDesc;
	}

	public int compareTo(PostPictureContent that) {
		final int BEFORE = -1;
		final int AFTER = 1;

		if (that == null) {
			return BEFORE;
		}

		Comparable thisPostPictureContent = this.getPostPicId();
		Comparable thatPostPictureContent = that.getPostPicId();

		if (thisPostPictureContent == null) {
			return AFTER;
		} else if (thatPostPictureContent == null) {
			return BEFORE;
		} else {
			return thisPostPictureContent.compareTo(thatPostPictureContent);
		}
	}

}
