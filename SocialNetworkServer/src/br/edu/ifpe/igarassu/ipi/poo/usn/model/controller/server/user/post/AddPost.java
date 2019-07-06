package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.post;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.HttpURLConnection;
import java.text.ParseException;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.User;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;

public class AddPost extends PAbstractHandler implements HttpHandler {

	public AddPost(UserSocialNetworkFacade facade) {
		super(facade);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void handle(HttpExchange he) throws IOException {
        System.out.println("Serving the request");

	    if (he.getRequestMethod().equalsIgnoreCase("POST")) {
	    	printRequestInfo(he);
//	    	((AbstractHandler) he).getMapper();
	    	
	        try {
	        	Map<String, Object> parameters = parsePostParameters(he);
	        	String name = parameters.get("name").toString();
	        	String text = parameters.get("text").toString();
	        	
//	        	User u = new User();
	        	Post post = new Post(name, text);
	        	
	        	
//	            Set<Map.Entry<String, List<String>>> entries = requestHeaders.entrySet();
//
	        	Headers requestHeaders = he.getRequestHeaders();
	            int contentLength = Integer.parseInt(requestHeaders.getFirst("Content-length"));
//	            System.out.println(""+requestHeaders.getFirst("Content-length"));
//
//	            InputStream is = he.getRequestBody();
//
//	            byte[] data = new byte[contentLength];
//	            int length = is.read(data);

	            Headers responseHeaders = he.getResponseHeaders();

	            he.sendResponseHeaders(HttpURLConnection.HTTP_OK, contentLength);

	            OutputStream os = he.getResponseBody();
	            
	            String response = "teste";

	            os.write(name.getBytes());
	            he.close();

	            } catch (NumberFormatException | IOException e) {
	            	
	            }
	        }

	    }
}


