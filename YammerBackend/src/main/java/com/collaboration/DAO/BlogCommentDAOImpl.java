package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.BlogComment;
import com.collaboration.model.Job;

@Repository("blogCommentDAO")
@Transactional

public class BlogCommentDAOImpl implements BlogCommentDAO 

{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment comment) {
		try
		{
			sessionFactory.getCurrentSession().save(comment);
			return true;
			
		}
		catch(Exception e)
		{   
			
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment comment) {
		try
		{
			sessionFactory.getCurrentSession().delete(comment);
			return true;
			
		}
		catch(Exception e)
		{   
			
			return false;
		}
	}

	@Override
	public List<BlogComment> listBlogComment(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId",blogId);
		List<BlogComment> listComment=query.list();
		session.close();
		return listComment;
	}

	@Override
	public BlogComment getBlogComment(int blogId) {
		Session session=sessionFactory.openSession();
		BlogComment blogComment=session.get(BlogComment.class, blogId);
		session.close();
		return blogComment;
	}

}
