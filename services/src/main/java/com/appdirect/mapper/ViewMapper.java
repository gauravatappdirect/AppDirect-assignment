package com.appdirect.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * Created by gaurav on 24/12/16.
 */
@Component
public class ViewMapper {

    private static ObjectMapper MAPPER = new ObjectMapper();

    public <T> T map(Object obj, Class<T> clazz) {
        MAPPER = MAPPER.configure(
                FAIL_ON_UNKNOWN_PROPERTIES, false);
        return MAPPER.convertValue(obj, clazz);
    }

    public <T> List<T> mapAll(Object obj, Class<T> clazz) {
        MAPPER = MAPPER.configure(
                FAIL_ON_UNKNOWN_PROPERTIES, false);
        return MAPPER.convertValue(obj, new TypeReference<List<T>>() {
        });
    }

    public ObjectMapper mapperInstance() {
        return MAPPER;
    }
}