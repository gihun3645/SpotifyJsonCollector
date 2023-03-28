package utills;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.porject.jsoncollector.model.Track;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class TrackJsonUtil {
    public static List<Track> readJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        List<Track> tracks = objectMapper.convertValue(jsonNode.get("tracks"), new TypeReference<List<Track>>() {});
        return tracks;
    }
}
