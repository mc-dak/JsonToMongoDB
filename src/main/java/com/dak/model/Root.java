package com.dak.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import com.mongodb.BasicDBObject;

public class Root extends BasicDBObject {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("event")
    private String event;

    @JsonProperty("task")
    private Task task;

    @JsonProperty("task_id")
    private Integer taskId;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    @JsonProperty("task")
    public Task getTask() {
        return task;
    }

    @JsonProperty("task")
    public void setTask(Task task) {
        this.task = task;
    }

    @JsonProperty("task_id")
    public Integer getTaskId() {
        return taskId;
    }

    @JsonProperty("task_id")
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
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
