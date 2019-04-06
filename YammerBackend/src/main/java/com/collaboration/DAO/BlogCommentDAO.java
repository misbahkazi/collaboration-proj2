package com.collaboration.DAO;


import java.util.List;


import com.collaboration.model.BlogComment;


public interface BlogCommentDAO {

	
	public boolean addBlogComment(BlogComment comment);
	public boolean deleteBlogComment(BlogComment comment);
	public List<BlogComment> listBlogComment(int blogId);
	public BlogComment getBlogComment(int blogId);
}
