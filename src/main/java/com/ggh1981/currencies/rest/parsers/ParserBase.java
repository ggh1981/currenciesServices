package com.ggh1981.currencies.rest.parsers;

import java.util.List;

public interface ParserBase <V, G> {

	List<V> restToEntityList(G json);
	
}
