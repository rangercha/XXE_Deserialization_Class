package servlet;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.*;



public class Serial {

	public static Object fromJSON(String s) throws IOException, ClassNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		MyValue value = new MyValue();
		mapper.enableDefaultTyping();
		mapper.setSerializationInclusion(Include.NON_NULL);
		value = mapper.readValue(s, MyValue.class);
		return value;
		
	}

	public static String toJSON(Serializable o) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(o);
		return jsonString;
	}
}

