package lumpofyums;
import java.sql.Timestamp;

public class Comments {
	protected int id;
	
	public Comments(int id,String comment, String username, int uid, String recipe_name, Timestamp created_at) {
		super();
		this.comment = comment;
		this.username = username;
		this.uid = uid;
		this.recipe_name = recipe_name;
		this.created_at =  created_at;
		this.id = id;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	protected String comment;
	protected int uid;
	protected String recipe_name;
	protected String username;
	Timestamp created_at;

	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	



}