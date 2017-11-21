package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by francois-mariemanicacci on 14/11/2017.
 */

public class JSONParser implements Parser {
    ////////////////////////////////////////////////////////
    ///
    /// ATTRIBUTS
    ///

    private String        m_rawData;
    private JSONObject    m_json;
    private JSONArray     m_items;

    private List<Map<String, String>> m_response;

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// CONSTRUCTORS
    ///

    private JSONParser () {
        m_response = new ArrayList<Map<String, String>>();
    }

    public JSONParser (String data) throws JSONException {
        this();

        m_rawData   = data;
        m_json      = new JSONObject(data);
        m_items     = m_json.getJSONArray("items");
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// TEST
    ///


    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// GETTERS
    ///

    /// PRIVATE

    private String getItemID (JSONObject jsonObject) {
        return jsonObject.optString("title");
    }

    private String getItemAuthor(JSONObject jsonObject) {
        return jsonObject.optString("author");
    }

    private String getItemSummary (JSONObject jsonObject) {
        return jsonObject.optString("summary");
    }

    private String getItemContent (JSONObject jsonObject) {
        return jsonObject.optString("content");
    }

    private String getItemLatitude (JSONObject jsonObject) {
        return jsonObject.optString("latitude");
    }

    private String getItemLongitude (JSONObject jsonObject) {
        return jsonObject.optString("longitude");
    }

    private String getItemDistance (JSONObject jsonObject) {
        return jsonObject.optString("distance");
    }

    private String getItemAddress (JSONObject jsonObject) {
        return jsonObject.optString("address");
    }

    private String getItemSmallThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("smallThumbnail");
    }

    private String getItemThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("thumbnail");
    }

    private String getItemOriginalThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("originalThumbnail");
    }

    private String getItemLargeThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("largeThumbnail");
    }

    private String getItemXLargeThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("xLargeThumbnail");
    }

    private String getItemXXLargeThumbnail (JSONObject jsonObject) {
        return jsonObject.optString("xxLargeThumbnail");
    }

    private String getItemPhoneNumber (JSONObject jsonObject) {
        return jsonObject.optString("phoneNumber");
    }

    private String getItemWebsite (JSONObject jsonObject) {
        return jsonObject.optString("website");
    }

    private Map<String, String> getItem (int index) throws JSONException {
        HashMap<String, String> _item       = new HashMap<String, String> ();
        JSONObject              _JSONObject = m_items.getJSONObject(index);

        _item.put("title", this.getItemID(_JSONObject));
        _item.put("author", this.getItemAuthor(_JSONObject));
        _item.put("summary", this.getItemSummary(_JSONObject));
        _item.put("content", this.getItemContent(_JSONObject));
        _item.put("latitude", this.getItemLatitude(_JSONObject));
        _item.put("longitude", this.getItemLongitude(_JSONObject));
        _item.put("distance", this.getItemDistance(_JSONObject));
        _item.put("address", this.getItemAddress(_JSONObject));
        _item.put("phoneNumber", this.getItemPhoneNumber(_JSONObject));
        _item.put("website", this.getItemWebsite(_JSONObject));
        _item.put("smallThumbnail", this.getItemSmallThumbnail(_JSONObject));
        _item.put("thumbnail", this.getItemThumbnail(_JSONObject));
        _item.put("originalThumbnail", this.getItemOriginalThumbnail(_JSONObject));
        _item.put("largeThumbnail", this.getItemLargeThumbnail(_JSONObject));
        _item.put("xLargeThumbnail", this.getItemXLargeThumbnail(_JSONObject));
        _item.put("xxLargeThumbnail", this.getItemXXLargeThumbnail(_JSONObject));

        return _item;
    }

    /// PUBLIC

    public List<Map<String, String>> getItems () throws JSONException {
        List<Map<String, String>> _items = new ArrayList<Map<String, String>>();

        for(int i = 0; i < m_items.length(); i++) _items.add(this.getItem(i));

        return _items;
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////
}
