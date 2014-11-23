/**
 * 
 */
package main.java.com.beauty.action;

import java.util.Comparator;

import main.java.com.beauty.beans.HomePostsContentBean;

/**
 * @author vinay
 * 
 */
public class PostsComparator implements Comparator<HomePostsContentBean> {

	@Override
	public int compare(HomePostsContentBean o1, HomePostsContentBean o2) {
		return ((o1.getPostPublishedDate())
				.compareTo(o2.getPostPublishedDate()) < 0) ? -1
				: (((o1.getPostPublishedDate()).compareTo(o2
						.getPostPublishedDate()) == 0) ? 0 : 1);
	}

}
