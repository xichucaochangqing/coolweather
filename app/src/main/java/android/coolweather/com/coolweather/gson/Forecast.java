package android.coolweather.com.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyp on 2017/9/3.
 */

public class Forecast {
    public String date;
    @SerializedName("tmp")
    public Temperature temperature;

    public class Temperature {
        public String max;
        public String min;

    }

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt_d")
        public String info;

    }
}
