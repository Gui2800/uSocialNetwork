/*
 *
 * IFPE - Federal Institute of Education, Science and Technology of Pernambuco
 * Informatics for the Internet
 * Object Oriented Programming
 * Professor: Allan Lima - allan.lima@igarassu.ifpe.edu.br
 * 
 * Public domain code, feel free to use, modify and redistribute it 
 *
 */

package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server;

import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import br.edu.ifpe.igarassu.ipi.poo.usn.data.entity.user.User;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.SocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.UserSocialNetworkFacade;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.AddUserHandler;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.GetUserByIdHandler;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.ListUserHandler;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.RemoveUserByIdHandler;
import br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.SearchByNameUserHandler;

/**
 *
 * REST API Server of the Social Network
 * 
 * @author Allan Diego Silva Lima - allan.lima@igarassu.ifpe.edu.br
 *
 */
public class SocialNetworkServer {
	public static void main(String[] args) throws Exception {
		UserSocialNetworkFacade facade = new SocialNetworkFacade();
		PostSocialNetFacade fcd = new PostNetFacade();

		addPosts(fcd);
		populateUsers(facade);

		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

		// each request has its own handler 
		server.createContext("/", new RootHandler());
		server.createContext("/user/get", new GetUserByIdHandler(facade));
		server.createContext("/user/add", new AddUserHandler(facade));
		server.createContext("/user/remove", new RemoveUserByIdHandler(facade));
		server.createContext("/user/search", new SearchByNameUserHandler(facade));
		server.createContext("/user/list", new ListUserHandler(facade));
		
		server.createContext("/post/list", new ListPost(fcd));
		server.createContext("/post/add", new AddPost(facade));
		
		server.setExecutor(null);

		server.start();
	}

	private static void addPosts(PostSocialNetFacade fcd) {
		fcd.addPost(new Post("Gui", "Testanto o teste para ser testado"));
	}
	
	private static void populateUsers(UserSocialNetworkFacade facade) {
		facade.addUser(new User(0, "Carla", "312", "liraCarla@teste.com", "(81)99588-6433"));
		// facade.addUser(new User(1, "Carlos", "541"));
		// facade.addUser(new User(2, "Marcos", "451"));
		// facade.addUser(new User(3, "Joao", "123"));
		// facade.addUser(new User(4, "Joana", "171"));
	}

}
