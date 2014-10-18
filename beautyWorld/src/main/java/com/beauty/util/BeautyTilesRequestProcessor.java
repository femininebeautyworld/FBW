/*
 * (c) 2005 BI, Inc.  All rights reserved.
 * $Source: /usr/local/ndscvsroot/products/penta-g/src/javaui/com/biperf/core/ui/tiles/BeaconTilesRequestProcessor.java,v $
 */

package main.java.com.beauty.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.TilesRequestProcessor;
import org.apache.struts.util.TokenProcessor;

public class BeautyTilesRequestProcessor extends TilesRequestProcessor
{
  /**
   * Overridden from
   * 
   * @see org.apache.struts.action.RequestProcessor#processActionPerform(javax.servlet.http.HttpServletRequest,
   *      javax.servlet.http.HttpServletResponse, org.apache.struts.action.Action,
   *      org.apache.struts.action.ActionForm, org.apache.struts.action.ActionMapping)
   * @param request
   * @param response
   * @param action
   * @param form
   * @param mapping
   * @return ActionForward return from the Action
   * @throws IOException
   * @throws ServletException
   */
  protected ActionForward processActionPerform( HttpServletRequest request,
                                               HttpServletResponse response,
                                               Action action,
                                               ActionForm form,
                                               ActionMapping mapping ) throws IOException,
      ServletException
  {
    ActionForward forward = null;
    forward = super.processActionPerform( request, response, action, form, mapping );
    if ( request.getParameter( "doNotSaveToken" ) == null )
    {
      if ( request.getSession( false ) != null )
      {
        TokenProcessor.getInstance().saveToken( request );
      }
    }
    return forward;
  }
}
