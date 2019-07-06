package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.SocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.ListUserHandler;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;


public abstract class PAbstractHandler extends ListUserHandler implements HttpHandler {
	
	
	private UserSocialNetworkFacade facade = null;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 
	 * Initializes the facade with the given parameter.  
	 * 	
	 * @param facade the facade of the 
	 */
	public PAbstractHandler(UserSocialNetworkFacade facade) {
		super(facade);
		this.facade = facade;
	}
	
	/**
	 * 
	 * Returns the facade of the social network
	 * 
	 * @return the facade of the social network
	 */
//	public UserSocialNetworkFacade getFacade() {
//		return this.facade;
//	}
	
	/**
	 * 
	 * Returns the JASON mapper object 
	 * 
	 * @return the JASON mapper object
	 */
	protected ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * Sets the JASON mapper object
	 * 
	 * @param mapper the new JASON mapper object
	 */
	protected void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}


	public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {
		if (query != null) {
			String pairs[] = query.split("[&]");
			for (String pair : pairs) {
				String param[] = pair.split("[=]");
				String key = null;
				String value = null;
				if (param.length > 0) {
					key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
				}

				if (param.length > 1) {
					value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
				}

				if (parameters.containsKey(key)) {
					Object obj = parameters.get(key);
					if (obj instanceof List<?>) {
						List<String> values = (List<String>) obj;
						values.add(value);

					} else if (obj instanceof String) {
						List<String> values = new ArrayList<String>();
						values.add((String) obj);
						values.add(value);
						parameters.put(key, values);
					}
				} else {
					parameters.put(key, value);
				}
			}
		}
	}

	
	protected Map<String, Object> parsePostParameters(HttpExchange exchange) throws UnsupportedEncodingException, IOException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String query = br.readLine();
		parseQuery(query, parameters);
		
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}

		return parameters;
	}
	
}
