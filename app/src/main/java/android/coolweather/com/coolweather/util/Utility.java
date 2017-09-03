package android.coolweather.com.coolweather.util;

import android.coolweather.com.coolweather.db.City;
import android.coolweather.com.coolweather.db.County;
import android.coolweather.com.coolweather.db.Province;
import android.coolweather.com.coolweather.gson.Weather;
import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cyp on 2017/9/3.
 */

public class Utility {
    public static boolean handleProvinceRespose(String respose) {
        if (!TextUtils.isEmpty(respose)) {
            try {
                JSONArray allprovinces = new JSONArray(respose);
                for (int i = 0; i < allprovinces.length(); i++) {
                    JSONObject provinceOBJ = allprovinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceOBJ.getString("name"));
                    province.setProvinceCode(provinceOBJ.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCityRespose(String respose, int provinceId) {
        if (!TextUtils.isEmpty(respose)) {
            try {
                JSONArray allCities = new JSONArray(respose);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityOBJ = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityOBJ.getString("name"));
                    city.setCityCode(cityOBJ.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static boolean handleCountyRespose(String respose, int cityId) {
        if (!TextUtils.isEmpty(respose)) {
            try {
                JSONArray allCounties = new JSONArray(respose);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject CountyOBJ = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(CountyOBJ.getString("name"));
                    county.setWeatherId(CountyOBJ.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static Weather handleWeatherResponse(String respose) {
        try {
            JSONObject jsonObject = new JSONObject(respose);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
