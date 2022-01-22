package lumpofyums;

public class Recipe {
	
	int id;
	String food_name;
	int prep_time;
	int cooking_time;
	String level;
	String description;
	String ingredients;
	String preparation;
	int uid;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Recipe(String food_name, int prep_time, int cooking_time, String level, String description, String ingredients, String preparation, int uid, String username) {
		
		super();
		this.food_name = food_name;
		this.prep_time = prep_time;
		this.cooking_time = cooking_time;
		this.level = level;
		this.description = description;
		this.ingredients = ingredients;
		this.preparation = preparation;
		this.uid = uid;
		this.username = username;
		
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getPrep_time() {
		return prep_time;
	}
	public void setPrep_time(int prep_time) {
		this.prep_time = prep_time;
	}
	public int getCooking_time() {
		return cooking_time;
	}
	public void setCooking_time(int cooking_time) {
		this.cooking_time = cooking_time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}


}
