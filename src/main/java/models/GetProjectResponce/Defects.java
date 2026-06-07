package models.GetProjectResponce;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Defects {

    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("open")
    @Expose
    public Integer open;
}
