/**
 * 
 */
package main.java.com.beauty.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.beauty.domain.Posts;
import main.java.com.beauty.service.PostActivityService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author vinay
 * 
 */
public class ViewPostsAction extends Action {

	private final String SUCCESS = "success";

	private PostActivityService postActivityService;

	public void setPostActivityService(PostActivityService postActivityService) {
		this.postActivityService = postActivityService;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<Posts> viewPostsList = new ArrayList<Posts>();
		viewPostsList = postActivityService.getPostsToViewForAdmin();

		request.setAttribute("viewPostsList", viewPostsList);
		return mapping.findForward(SUCCESS);

	}

}
