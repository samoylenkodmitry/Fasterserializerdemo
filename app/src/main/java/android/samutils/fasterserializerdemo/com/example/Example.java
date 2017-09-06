
package android.samutils.fasterserializerdemo.com.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.samutils.fasterserializer.processor.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "calctime",
    "cnt",
    "list"
})
public class Example implements Parcelable
{

    @JsonProperty("cod")
    @Value
    public String cod;
    @JsonProperty("calctime")
    @Value
    public float calctime;
    @JsonProperty("cnt")
    @Value
    public int cnt;
    @JsonProperty("list")
    @Value
    public List[] list = null;
    public final static Parcelable.Creator<Example> CREATOR = new Creator<Example>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Example createFromParcel(Parcel in) {
            Example instance = new Example();
            instance.cod = ((String) in.readValue((String.class.getClassLoader())));
            instance.calctime = ((float) in.readValue((float.class.getClassLoader())));
            instance.cnt = ((int) in.readValue((int.class.getClassLoader())));
            instance.list= ((List[]) in.readArray((List.class.getClassLoader())));
            return instance;
        }

        public Example[] newArray(int size) {
            return (new Example[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(calctime);
        dest.writeValue(cnt);
        dest.writeArray(list);
    }

    public int describeContents() {
        return  0;
    }

}
