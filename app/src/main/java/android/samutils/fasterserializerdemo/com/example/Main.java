
package android.samutils.fasterserializerdemo.com.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.samutils.fasterserializer.processor.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity"
})
public class Main implements Parcelable
{

    @JsonProperty("temp")
    @Value
    public float temp;
    @JsonProperty("temp_min")
    @Value
    public int tempMin;
    @JsonProperty("temp_max")
    @Value
    public int tempMax;
    @JsonProperty("pressure")
    @Value
    public int pressure;
    @JsonProperty("sea_level")
    @Value
    public float seaLevel;
    @JsonProperty("grnd_level")
    @Value
    public float grndLevel;
    @JsonProperty("humidity")
    @Value
    public int humidity;
    public final static Parcelable.Creator<Main> CREATOR = new Creator<Main>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Main createFromParcel(Parcel in) {
            Main instance = new Main();
            instance.temp = ((float) in.readValue((float.class.getClassLoader())));
            instance.tempMin = ((int) in.readValue((int.class.getClassLoader())));
            instance.tempMax = ((int) in.readValue((int.class.getClassLoader())));
            instance.pressure = ((int) in.readValue((int.class.getClassLoader())));
            instance.seaLevel = ((float) in.readValue((float.class.getClassLoader())));
            instance.grndLevel = ((float) in.readValue((float.class.getClassLoader())));
            instance.humidity = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Main[] newArray(int size) {
            return (new Main[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(tempMin);
        dest.writeValue(tempMax);
        dest.writeValue(pressure);
        dest.writeValue(seaLevel);
        dest.writeValue(grndLevel);
        dest.writeValue(humidity);
    }

    public int describeContents() {
        return  0;
    }

}
