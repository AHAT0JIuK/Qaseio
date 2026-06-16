package models.GetProjectResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Runs {

    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("active")
    @Expose
    public Integer active;
}
