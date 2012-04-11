package com.yunbo.obase.core.controller.format;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**
 * JSON字符串格式化工具
 * 
 * @author nicholas
 * 
 */
public class JsonFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<JsonFormat> {
	private static Logger log = Logger.getLogger(JsonFormatAnnotationFormatterFactory.class);
	
	public Set<Class<?>> getFieldTypes() {
		Set<Class<?>> fieldTypes = new HashSet<Class<?>>(1, 1);
		fieldTypes.add(String.class);
		fieldTypes.add(Object.class);
		fieldTypes.add(List.class);
		fieldTypes.add(Collection.class);
		fieldTypes.add(Set.class);

		return fieldTypes;
	}

	public Parser<?> getParser(JsonFormat annotation, Class<?> fieldType) {
		return new ParamFormatter(fieldType, annotation.contentType());
	}

	public Printer<?> getPrinter(JsonFormat annotation, Class<?> fieldType) {
		return new ParamFormatter(fieldType, annotation.contentType());
	}

	private static class ParamFormatter implements Formatter<Object> {
		private Class<?> contentType;
		private Class<?> fieldType;

		ObjectMapper mapper = new ObjectMapper();

		public ParamFormatter(Class<?> fieldType, Class<?> contentType) {
			this.contentType = contentType;
			this.fieldType = fieldType;
		}

		public String print(Object object, Locale locale) {
			try {
				String str = mapper.writeValueAsString(object);
				return str;
			} catch (JsonGenerationException e) {
				log.warn(e.getMessage(), e);
			} catch (JsonMappingException e) {
				log.warn(e.getMessage(), e);
			} catch (IOException e) {
				log.warn(e.getMessage(), e);
			}

			return "";
		}

		public Object parse(String text, Locale locale) throws ParseException {
			try {
				Object data = null;
				if (contentType != null) {
					if (List.class.equals(fieldType) || Collection.class.equals(fieldType)) {
						data = mapper.readValue(text, TypeFactory.collectionType(List.class, contentType));
					} else if (Set.class.equals(fieldType)) {
						data = mapper.readValue(text, TypeFactory.collectionType(Set.class, contentType));
					}
				} else {
					data = mapper.readValue(text, contentType);
				}

				return data;
			} catch (JsonParseException e) {
				log.warn(e.getMessage(), e);
				throw new ParseException(e.getMessage(), 0);
			} catch (JsonMappingException e) {
				log.warn(e.getMessage(), e);
				throw new ParseException(e.getMessage(), 0);
			} catch (IOException e) {
				log.warn(e.getMessage(), e);
				throw new ParseException(e.getMessage(), 0);
			}
		}
	}

}
