
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
            int sz=in.readInt();
            instance.list = new List[sz];
            for (int i = 0; i < sz; i++) {
                instance.list[i]=in.readParcelable(List.class.getClassLoader());
            }
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
        dest.writeInt(list.length);
        for (final List list1 : list) {
            dest.writeParcelable(list1, 0);
        }
    }

    public int describeContents() {
        return  0;
    }

}
