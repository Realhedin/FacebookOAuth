package com.javapapers.java.social.facebook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MainMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
        String code = req.getParameter("code");
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);

		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>Facebook Login using Java with OAuth protocol</h1>");
		out.println("<h2>Application Main Menu</h2>");
		out.println("<div>Welcome, "+fbProfileData.get("name")+"!");
        out.println("<div>Your Email: " +
                ((fbProfileData.get("email") == null) ? "unknown" : fbProfileData.get("email")));
        out.println("<div>Your Gender: " +
                ((fbProfileData.get("gender") == null) ? "unknown" : fbProfileData.get("gender")));
    }

}
