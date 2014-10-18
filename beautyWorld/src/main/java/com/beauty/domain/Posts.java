/**
 * 
 */
package main.java.com.beauty.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author vinay
 * 
 */
public class Posts {

	private Long postId;
	private String postTitle;
	private String postType;
	private String postViewType;
	private String postDescription;
	private Date dateCreated;
	private Date datePublished;
	private Set<PostPictureContent> postPictureContents = new HashSet<PostPictureContent>();
	private Set<PostVideoContent> postVideoContents = new HashSet<PostVideoContent>();

/*	public Posts(String postTitle, String postType, String postViewType,
			Date dateCreated, Date datePublished ) {
		super();
		this.postTitle = postTitle;
		this.postType = postType;
		this.postViewType = postViewType;
		this.dateCreated = dateCreated;
		this.datePublished = datePublished;
	}*/

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostViewType() {
		return postViewType;
	}

	public void setPostViewType(String postViewType) {
		this.postViewType = postViewType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public Set<PostPictureContent> getPostPictureContents() {
		return postPictureContents;
	}

	public void setPostPictureContents(
			Set<PostPictureContent> postPictureContents) {
		this.postPictureContents = postPictureContents;
	}

	public Set<PostVideoContent> getPostVideoContents() {
		return postVideoContents;
	}

	public void setPostVideoContents(Set<PostVideoContent> postVideoContents) {
		this.postVideoContents = postVideoContents;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

}
