package com.dak.model;

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
        "approvals",
        "author",
        "comments",
        "create_date",
        "due_date",
        "fields",
        "form_id",
        "id",
        "last_modified_date",
        "list_ids",
        "text"
})
public class Task {

    @JsonProperty("approvals")
    private List<List<Approval>> approvals = null;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("create_date")
    private String createDate;
    @JsonProperty("due_date")
    private String dueDate;
    @JsonProperty("fields")
    private List<Field> fields = null;
    @JsonProperty("form_id")
    private Integer formId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("last_modified_date")
    private String lastModifiedDate;
    @JsonProperty("list_ids")
    private List<Integer> listIds = null;
    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("approvals")
    public List<List<Approval>> getApprovals() {
        return approvals;
    }

    @JsonProperty("approvals")
    public void setApprovals(List<List<Approval>> approvals) {
        this.approvals = approvals;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    @JsonProperty("fields")
    public List<Field> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    @JsonProperty("form_id")
    public Integer getFormId() {
        return formId;
    }

    @JsonProperty("form_id")
    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("last_modified_date")
    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    @JsonProperty("last_modified_date")
    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @JsonProperty("list_ids")
    public List<Integer> getListIds() {
        return listIds;
    }

    @JsonProperty("list_ids")
    public void setListIds(List<Integer> listIds) {
        this.listIds = listIds;
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
