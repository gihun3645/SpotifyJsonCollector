package utills;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.porject.jsoncollector.model.History;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoryJsonUtil {
    public static List<History> readJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);
        List<History> histories = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            History history = new History();
            history.setEndTime(String.valueOf(LocalDateTime.parse(node.get("endTime").asText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
            history.setArtistName(node.get("artistName").asText());
            history.setTrackName(node.get("trackName").asText());
            history.setMsPlayed(node.get("msPlayed").asInt());
            histories.add(history);
        }
        return histories;
    }
}
