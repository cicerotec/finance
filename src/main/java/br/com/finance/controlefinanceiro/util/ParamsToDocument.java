package br.com.finance.controlefinanceiro.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ParamsToDocument {
    public <T> T transform(Map<String, Object> params, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json = mapper.writeValueAsString(params);
        T transformed = mapper.readValue(json, clazz);

        return transformed;
    }
}
