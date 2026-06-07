package models.GetProjectResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counts {

    @SerializedName("cases")
    @Expose
    public Integer cases;
    @SerializedName("suites")
    @Expose
    public Integer suites;
    @SerializedName("milestones")
    @Expose
    public Integer milestones;
    @SerializedName("runs")
    @Expose
    public Runs runs;
    @SerializedName("defects")
    @Expose
    public Defects defects;
}
