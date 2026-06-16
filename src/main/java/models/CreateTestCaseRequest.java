package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTestCaseRequest {

    @SerializedName("steps_type")
    @Expose
    public String stepsType;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("preconditions")
    @Expose
    public String preconditions;
    @SerializedName("postconditions")
    @Expose
    public String postconditions;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("severity")
    @Expose
    public Integer severity;
    @SerializedName("priority")
    @Expose
    public Integer priority;
    @SerializedName("behavior")
    @Expose
    public Integer behavior;
    @SerializedName("type")
    @Expose
    public Integer type;
    @SerializedName("layer")
    @Expose
    public Integer layer;
    @SerializedName("is_flaky")
    @Expose
    public Integer isFlaky;
    @SerializedName("suite_id")
    @Expose
    public Integer suiteId;
    @SerializedName("milestone_id")
    @Expose
    public Integer milestoneId;
    @SerializedName("automation")
    @Expose
    public Integer automation;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
}
