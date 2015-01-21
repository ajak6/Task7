package customerController;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import databeans.Customer;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	public void init() throws ServletException {
        Model model = new Model(getServletConfig());
        
        Action.add(new LoginAction(model));
   //     Action.add(new RequestCheckAction(model));
        Action.add(new FundResearchAction(model));
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage,request,response);
    }
    
    private String performTheAction(HttpServletRequest request) {
        HttpSession session     = request.getSession(true);
        String      servletPath = request.getServletPath();
 //       Customer    customer = (Customer) session.getAttribute("customer");
        String      action = getActionName(servletPath);
 /*       
        if (customer == null) {
        	
        	// If the user hasn't logged in, so login is the only option
        	if (action.equals("fundResearch.doc") || action.equals("login.do") || action.equals("list.do") || action.equals("view.do")) {
    			return Action.perform(action,request);
            }
        	else {
        		return Action.perform("login.do",request);
        		}
        }
       
        if (action.equals("welcome")) {
        	// User is logged in, but at the root of our web app
			return Action.perform("manage.do",request);
        }
     */   
      	// Let the logged in user run his chosen action
		return Action.perform(action,request);
    }
    
    private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	if (nextPage == null) {
    		response.sendError(HttpServletResponse.SC_NOT_FOUND,request.getServletPath());
    		return;
    	}
    	
    	if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
    	}
    	
    	if (nextPage.endsWith(".jsp")) {
	   		RequestDispatcher d = request.getRequestDispatcher(nextPage);
	   		d.forward(request,response);
	   		return;
    	}
    	
    	response.sendRedirect(nextPage);
    	return;
   // 	throw new ServletException(Controller.class.getName()+".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }
    
    private String getActionName(String path) {
    	// We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }

}
