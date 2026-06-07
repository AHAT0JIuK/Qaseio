package models.GetTestCaseResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTestCaseResponse {

    @SerializedName("status")
    @Expose
    public Boolean status;
    @SerializedName("result")
    @Expose
    public Result result;
    @SerializedName("errorMessage")
    @Expose
    public String errorMessage;
}
