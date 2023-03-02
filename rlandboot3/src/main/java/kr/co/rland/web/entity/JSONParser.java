package kr.co.rland.web.entity;

import java.lang.reflect.Field;

public class JSONParser {
	
	private Object entity;
	
	public JSONParser(Object entity) {
		this.entity = entity;
	}
	
	public String toJSON() throws IllegalArgumentException, IllegalAccessException {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("{");
		
		Field[] fields = entity.getClass().getDeclaredFields();
		for(Field f : fields) {
			String name = f.getName();
			Column col = f.getAnnotation(Column.class);
			if(col != null)
				name = col.value();
			
			f.setAccessible(true);
			Object value = f.get(entity);
			String fieldValue = String.format("\"%s\":%s", name, value);
			
			builder.append(fieldValue);
			//if
			builder.append(",");
		}
		
		builder.append("}");
		
		String json = builder.toString();
		
		return json;
	}
}
