package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 20151364 on 21/11/2017.
 */
public class DataModel {
    String title;
    String content;
    List<String> images;
    String smallThumbnail;
    String thumbnail;
    String originalThumbnail;
    String largeThumbnail;
    String xLargeThumbnail;
    String xxLargeThumbnail;
    float latitude;
    float longitude;
    float distance;
    String address;
    String phoneNumber;
    String website;


    public DataModel(JSONObject jsonObject) {
            images = new ArrayList<>();

            setTitle(jsonObject.optString("title"));
            setContent(jsonObject.optString("author"));
            setImages(jsonObject.optJSONArray("images"));
            setSmallThumbnail(jsonObject.optString("smallThumbnail"));
            setThumbnail(jsonObject.optString("thumbnail"));
            setLargeThumbnail(jsonObject.optString("largeThumbnail"));
            setOriginalThumbnail(jsonObject.optString("originalThumbnail"));
            setxLargeThumbnail(jsonObject.optString("xLargeThumbnail"));
            setXxLargeThumbnail(jsonObject.optString("xxLargeThumbnail"));
            setLatitude(jsonObject.optString("latitude"));
            setLongitude(jsonObject.optString("longitude"));
            setDistance(jsonObject.optString("distance"));
            setAddress(jsonObject.optString("address"));
            setPhoneNumber(jsonObject.optString("phoneNumber"));
            setWebsite(jsonObject.optString("website"));


    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(JSONArray j) {
        for (int i =0; i<j.length();i++){
            JSONObject jo = j.optJSONObject(i);
            images.add(jo.optString("url"));
        }

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getOriginalThumbnail() {
        return originalThumbnail;
    }

    public void setOriginalThumbnail(String originalThumbnail) {
        this.originalThumbnail = originalThumbnail;
    }

    public String getLargeThumbnail() {
        return largeThumbnail;
    }

    public void setLargeThumbnail(String largeThumbnail) {
        this.largeThumbnail = largeThumbnail;
    }

    public String getxLargeThumbnail() {
        return xLargeThumbnail;
    }

    public void setxLargeThumbnail(String xLargeThumbnail) {
        this.xLargeThumbnail = xLargeThumbnail;
    }

    public String getXxLargeThumbnail() {
        return xxLargeThumbnail;
    }

    public void setXxLargeThumbnail(String xxLargeThumbnail) {
        this.xxLargeThumbnail = xxLargeThumbnail;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = Float.parseFloat(longitude);
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = Float.parseFloat(latitude);
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = Float.parseFloat(distance);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
