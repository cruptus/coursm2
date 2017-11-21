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

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// CONSTRUCTORS
    ///

    public JSONParser (String data) throws JSONException {
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
    /// GETTERS
    ///

    public String getRawData () {
        return m_rawData;
    }

    public JSONObject getJSON () {
        return m_json;
    }

    public JSONArray getJSONArray () {
        return m_items;
    }

    public JSONObject getJSONItem (int index) {
        return m_items.optJSONObject(index);
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////
}
