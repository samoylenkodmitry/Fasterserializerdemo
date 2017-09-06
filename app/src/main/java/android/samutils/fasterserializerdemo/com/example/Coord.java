
package android.samutils.fasterserializerdemo.com.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.samutils.fasterserializer.processor.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lon",
    "lat"
})
public class Coord implements Parcelable
{

    @JsonProperty("lon")
    @Value
    public float lon;
    @JsonProperty("lat")
    @Value
    public float lat;
    public final static Parcelable.Creator<Coord> CREATOR = new Creator<Coord>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Coord createFromParcel(Parcel in) {
            Coord instance = new Coord();
            instance.lon = ((float) in.readValue((float.class.getClassLoader())));
            instance.lat = ((float) in.readValue((float.class.getClassLoader())));
            return instance;
        }

        public Coord[] newArray(int size) {
            return (new Coord[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lon);
        dest.writeValue(lat);
    }

    public int describeContents() {
        return  0;
    }

}
