package json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "added_list_ids",
        "approvals_added",
        "author",
        "create_date",
        "due_date",
        "field_updates",
        "id",
        "text"
})
public class Comment {

    @JsonProperty("added_list_ids")
    private List<Integer> addedListIds = null;
    @JsonProperty("approvals_added")
    private List<List<ApprovalsAdded>> approvalsAdded = null;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("create_date")
    private String createDate;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("field_updates")
    private List<FieldUpdate> fieldUpdates = null;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("added_list_ids")
    public List<Integer> getAddedListIds() {
        return addedListIds;
    }

    @JsonProperty("added_list_ids")
    public void setAddedListIds(List<Integer> addedListIds) {
        this.addedListIds = addedListIds;
    }

    @JsonProperty("approvals_added")
    public List<List<ApprovalsAdded>> getApprovalsAdded() {
        return approvalsAdded;
    }

    @JsonProperty("approvals_added")
    public void setApprovalsAdded(List<List<ApprovalsAdded>> approvalsAdded) {
        this.approvalsAdded = approvalsAdded;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("create_date")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("create_date")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("due_date")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("due_date")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("field_updates")
    public List<FieldUpdate> getFieldUpdates() {
        return fieldUpdates;
    }

    @JsonProperty("field_updates")
    public void setFieldUpdates(List<FieldUpdate> fieldUpdates) {
        this.fieldUpdates = fieldUpdates;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
