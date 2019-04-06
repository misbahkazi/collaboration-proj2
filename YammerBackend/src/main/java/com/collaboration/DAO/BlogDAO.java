package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.Blog;

public interface BlogDAO {
	
	
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean incrementLikes(Blog blog);
	public boolean incrementDislikes(Blog blog);
	public boolean approvedBlog(Blog blog);
	public boolean rejectBlog(Blog blog);

	
	
}
