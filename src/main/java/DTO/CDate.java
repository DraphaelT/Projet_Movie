package DTO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CDate extends JsonDeserializer<Date>{

	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		String dateChaine = jsonParser.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
		try {
			return format.parse(dateChaine);
		}catch (ParseException e) {
			return null;
		}
	}
}
