package android.samutils.fasterserializerdemo.com.example;

import android.os.Parcel;
import android.os.Parcelable;
import android.samutils.fasterserializer.processor.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "coord",
    "main",
    "dt",
    "wind",
    "rain",
    "clouds",
    "weather"
})
public class List implements Parcelable
{

    @JsonProperty("id")
    @Value
    public int id;
    @JsonProperty("name")
    @Value
    public String name;
    @JsonProperty("coord")
    @Value
    public Coord coord;
    @JsonProperty("main")
    @Value
    public Main main;
    @JsonProperty("dt")
    @Value
    public int dt;
    @JsonProperty("wind")
    @Value
    public Wind wind;
    @JsonProperty("rain")
    @Value
    public Rain rain;
    @JsonProperty("clouds")
    @Value
    public Clouds clouds;
    @JsonProperty("weather")
    @Value
    public Weather[] weather = null;
    public final static Parcelable.Creator<List> CREATOR = new Creator<List>() {


        @SuppressWarnings({
            "unchecked"
        })
        public List createFromParcel(Parcel in) {
            List instance = new List();
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.coord = ((Coord) in.readValue((Coord.class.getClassLoader())));
            instance.main = ((Main) in.readValue((Main.class.getClassLoader())));
            instance.dt = ((int) in.readValue((int.class.getClassLoader())));
            instance.wind = ((Wind) in.readValue((Wind.class.getClassLoader())));
            instance.rain = ((Rain) in.readValue((Rain.class.getClassLoader())));
            instance.clouds = ((Clouds) in.readValue((Clouds.class.getClassLoader())));
            instance.weather= ((Weather[]) in.readArray((Weather.class.getClassLoader())));
            return instance;
        }

        public List[] newArray(int size) {
            return (new List[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(coord);
        dest.writeValue(main);
        dest.writeValue(dt);
        dest.writeValue(wind);
        dest.writeValue(rain);
        dest.writeValue(clouds);
        dest.writeArray(weather);
    }

    public int describeContents() {
        return  0;
    }
	
}
