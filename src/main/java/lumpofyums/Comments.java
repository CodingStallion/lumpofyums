package lumpofyums;

public class Comments {
	protected int id;
	protected String comment;
	protected int uid;
	protected String recipe_name;
	protected String username;

	public Comments(String comment, int uid, String username) {
		super();
		this.comment = comment;
		this.uid = uid;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserName() {
		return id;
	}

	public void setUserName(String username) {
		this.username = username;
	}

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

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

}