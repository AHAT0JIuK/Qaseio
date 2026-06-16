package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteProjectResponse {

    @SerializedName("status")
    @Expose
    public Boolean status;
}
