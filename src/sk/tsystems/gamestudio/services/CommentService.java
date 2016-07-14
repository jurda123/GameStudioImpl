package sk.tsystems.gamestudio.services;

public interface CommentService {
	
	public void addComment();

	public void getAllCommentsForGame(String game);
	
	public int getNumberOfComments();
}
