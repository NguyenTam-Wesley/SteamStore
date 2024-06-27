package com.liferay.steamweb.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.steamweb.constants.SteamWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SteamWebPortletKeys.STEAMWEB,
        "mvc.command.name=menu_publisher",
        "mvc.command.name=menu_game"
    }
)
public class RenderMvcCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        String mvcRenderCommandName = renderRequest.getParameter("mvcRenderCommandName");
        
        if ("menu_publisher".equals(mvcRenderCommandName)) {
            return "/publisher/menu_publisher.jsp";
        }
        return "/game/menu_game.jsp";
    }
}
