package dao;

import model.Category;
import java.util.List;
public interface CategoryDao {
	void insert(Category category) throws Exception;

	void delete(int id) throws Exception;
	
	void update(Category category);
	
	Category get(int id) throws Exception;
	
	List<Category> listCategory(String name);
}
