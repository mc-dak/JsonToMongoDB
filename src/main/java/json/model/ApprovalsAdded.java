package json.model;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "person",
        "step"
})
public class ApprovalsAdded {

    @JsonProperty("person")
    private Person person;
    @JsonProperty("step")
    private Integer step;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("person")
    public Person getPerson() {
        return person;
    }

    @JsonProperty("person")
    public void setPerson(Person person) {
        this.person = person;
    }

    @JsonProperty("step")
    public Integer getStep() {
        return step;
    }

    @JsonProperty("step")
    public void setStep(Integer step) {
        this.step = step;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
