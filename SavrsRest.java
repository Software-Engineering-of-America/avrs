package com.seasoft.savrs;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public interface SavrsRest {

	default String getBrowseOutputUrl(String host) {
		return host + "/sea/savrs/api01/browseOutput";
	}

	default String getFilterListtUrl(String host) {
		return host + "/sea/savrs/api01/filterList";
	}

	default String getLogonUrl(String host) {
		return host + "/sea/savrs/api01/login";
	}
	
	default String getDDListUrl(String host) {
		return host + "/sea/savrs/api01/ddlist";
	}

	default void prettyPrint(String header, Object j)
			throws IOException, JsonGenerationException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		String indented = mapper.defaultPrettyPrintingWriter().writeValueAsString(j);
		System.out.println(header);
		System.out.println(indented);
	}

}
