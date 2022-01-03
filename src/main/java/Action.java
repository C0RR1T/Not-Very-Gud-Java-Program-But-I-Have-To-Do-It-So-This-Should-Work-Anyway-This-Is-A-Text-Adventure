import com.fasterxml.jackson.annotation.JsonProperty;


record Action(@JsonProperty String ifState, @JsonProperty String message, @JsonProperty String addState, @JsonProperty String room) {

}

