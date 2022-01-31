package lumpofyums;


public class CommentsDetails {
	
	
	protected String comment;
	protected int uid;
	protected int id;
	protected String recipe_name;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public CommentsDetails(int id,String comment, int uid, String recipe_name) {
		super();
		this.comment = comment;
		this.uid = uid;
		this.recipe_name = recipe_name;
		this.id = id;

		
	

}}
