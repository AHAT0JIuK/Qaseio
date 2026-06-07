package models.GetTestCaseResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("position")
    @Expose
    public Integer position;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("preconditions")
    @Expose
    public String preconditions;
    @SerializedName("postconditions")
    @Expose
    public String postconditions;
    @SerializedName("severity")
    @Expose
    public Integer severity;
    @SerializedName("priority")
    @Expose
    public Integer priority;
    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("layer")
    @Expose
    public Integer layer;
    @SerializedName("is_flaky")
    @Expose
    public Integer isFlaky;
    @SerializedName("is_muted")
    @Expose
    public Boolean isMuted;
    @SerializedName("behavior")
    @Expose
    public Integer behavior;
    @SerializedName("automation")
    @Expose
    public Integer automation;
    @SerializedName("isManual")
    @Expose
    public Boolean isManual;
    @SerializedName("isToBeAutomated")
    @Expose
    public Boolean isToBeAutomated;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("milestone_id")
    @Expose
    public Object milestoneId;
    @SerializedName("suite_id")
    @Expose
    public Object suiteId;
    @SerializedName("links")
    @Expose
    public List<Object> links;
    @SerializedName("custom_fields")
    @Expose
    public List<Object> customFields;
    @SerializedName("attachments")
    @Expose
    public List<Object> attachments;
    @SerializedName("steps_type")
    @Expose
    public Object stepsType;
    @SerializedName("steps")
    @Expose
    public List<Object> steps;
    @SerializedName("params")
    @Expose
    public List<Object> params;
    @SerializedName("parameters")
    @Expose
    public List<Object> parameters;
    @SerializedName("member_id")
    @Expose
    public Integer memberId;
    @SerializedName("author_id")
    @Expose
    public Integer authorId;
    @SerializedName("author_uuid")
    @Expose
    public String authorUuid;
    @SerializedName("tags")
    @Expose
    public List<Object> tags;
    @SerializedName("deleted")
    @Expose
    public Object deleted;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("updated")
    @Expose
    public String updated;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
}
