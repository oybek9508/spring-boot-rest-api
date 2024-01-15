package com.oybek.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBean", filter);

		FilteringBean filteringBean = new FilteringBean("value1", "value2", "value4");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBean);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringBeanList(){
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBean", filter);

		List<FilteringBean> filteringBeans =  Arrays.asList(new FilteringBean("value1", "value2", "value3"), new FilteringBean("value4", "value5", "value6"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBeans);
		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;

	}
}
