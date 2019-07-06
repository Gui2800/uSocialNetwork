package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.post;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.User;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.AbstractHandler;

public class ListPost extends AbstractHandler{
	
	public ListPost(PostSocialNetFacade fcd) {
		super(fcd);
	}
	
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		try {
			printRequestInfo(exchange);

			System.out.println("list posts");
			List<Post> posts = super.getFcd().listPosts();

			ObjectMapper mapper = new ObjectMapper();

			String response = mapper.writeValueAsString(posts);

			System.out.println(response);
			exchange.sendResponseHeaders(200, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();

		} catch (Exception ex) {
			ex.printStackTrace();

			// TODO change the response to a JSON Object
			String response = "Failure";

			exchange.sendResponseHeaders(401, response.length());

			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

	}
}
