package sk.tsystems.gamestudio.services.jpa;

import java.util.List;
import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.ness.jpa.JpaHelper;
import sk.tsystems.gamestudio.entities.CommentEntity;
import sk.tsystems.gamestudio.games.minesweeper.BestTimes.PlayerTime;
import sk.tsystems.gamestudio.services.CommentService;

public class CommentHibernate implements CommentService{
 CommentEntity com;
  private String comment;
	
	public CommentHibernate(String comment) {
		com = new CommentEntity();
		com.setCommentar(comment);
	}
	
	@Override
	public void addComment() {
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(comment);
		EntityManager m = JpaHelper.getEntityManager();
		Query query = m.createQuery("select s from player s where s.meno=:meno ");
		List list = query.getResultList();
		

	}

	@Override
	public String[] getAllCommentsForGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfComments(String gameName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
