package br.edu.ifpe.igarassu.ipi.poo.usn.model.controller.server.user.post;

import java.util.List;

public interface PostSocialNetFacade {
	
	public List<Post> listPosts();

	public void addPost(Post post);
}
