
package android.samutils.fasterserializerdemo.com.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.samutils.fasterserializer.processor.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg",
    "var_beg",
    "var_end"
})
public class Wind implements Parcelable
{

    @JsonProperty("speed")
    @Value
    public float speed;
    @JsonProperty("deg")
    @Value
    public int deg;
    @JsonProperty("var_beg")
    @Value
    public int varBeg;
    @JsonProperty("var_end")
    @Value
    public int varEnd;
    public final static Parcelable.Creator<Wind> CREATOR = new Creator<Wind>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Wind createFromParcel(Parcel in) {
            Wind instance = new Wind();
            instance.speed = ((float) in.readValue((float.class.getClassLoader())));
            instance.deg = ((int) in.readValue((int.class.getClassLoader())));
            instance.varBeg = ((int) in.readValue((int.class.getClassLoader())));
            instance.varEnd = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Wind[] newArray(int size) {
            return (new Wind[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(speed);
        dest.writeValue(deg);
        dest.writeValue(varBeg);
        dest.writeValue(varEnd);
    }

    public int describeContents() {
        return  0;
    }

}
