package br.com.middleware.model;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Mapper for the basic mapping functions.
 */
public interface BaseMapper {

    default <T> T map(Optional<T> value) {
        return value.orElse(null);
    }

    default Map map(JsonNode value) {
        Map<String, Object> result = null;
        if (value != null) {
            result = new ObjectMapper().convertValue(value, new TypeReference<Map<String, Object>>() {
            });
        }
        return result;
    }

    default String map(OffsetDateTime offsetDateTime) {
        return offsetDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
    }

}
