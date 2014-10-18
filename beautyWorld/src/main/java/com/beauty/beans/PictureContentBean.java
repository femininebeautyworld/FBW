/**
 * 
 */
package main.java.com.beauty.beans;

import org.apache.struts.upload.FormFile;

/**
 * @author vinay
 * 
 */
public class PictureContentBean {

	private FormFile postPicture;
	private String postPictureDescription;
	private String imageDirPath;

	public PictureContentBean() {
		super();
	}

	public FormFile getPostPicture() {
		return postPicture;
	}

	public void setPostPicture(FormFile postPicture) {
		this.postPicture = postPicture;
	}

	public String getPostPictureDescription() {
		return postPictureDescription;
	}

	public void setPostPictureDescription(String postPictureDescription) {
		this.postPictureDescription = postPictureDescription;
	}

	public String getImageDirPath() {
		return imageDirPath;
	}

	public void setImageDirPath(String imageDirPath) {
		this.imageDirPath = imageDirPath;
	}
}
