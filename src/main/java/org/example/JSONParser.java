package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;
import java.util.List;

public class JSONParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<CatFact> getFacts(CloseableHttpResponse response) throws IOException {
        return mapper.readValue(response.getEntity().getContent(), new TypeReference<List<CatFact>>() {});
    }
}
