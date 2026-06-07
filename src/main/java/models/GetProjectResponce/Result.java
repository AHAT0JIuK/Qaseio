package models.GetProjectResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("counts")
    @Expose
    public Counts counts;
}
