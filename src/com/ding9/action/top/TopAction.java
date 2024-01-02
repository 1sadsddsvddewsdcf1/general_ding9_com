package com.ding9.action.top;

import com.ding9.util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TopAction
  extends Action
{
  private static final Log log = LogFactory.getLog(TopAction.class);
  



  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
  {
    String cid = request.getParameter("channelId");
    int channelId;  if (StringUtils.isNotBlank(cid)) {
      channelId = Integer.parseInt(cid);
    } else {
      channelId = 5;
    }
    if (log.isInfoEnabled()) {
      log.info("channelId : " + channelId);
    }
    request.setAttribute("channelId", Integer.valueOf(channelId));
    request.setAttribute("channelDomain", Constants.getChannelDomain(channelId));
    request.setAttribute("channelName", Constants.getChannelName(channelId));
    return mapping.findForward("top");
  }
}
