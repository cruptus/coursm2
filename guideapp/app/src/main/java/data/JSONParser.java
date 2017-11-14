package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by francois-mariemanicacci on 14/11/2017.
 */

public class JSONParser implements Parser {
    ////////////////////////////////////////////////////////
    ///
    /// ATTRIBUTS
    ///

    private String        m_data;
    private JSONObject    m_reader;

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// CONSTRUCTORS
    ///

    public JSONParser (String data) {
        try {
            m_data   = data;
            m_reader = new JSONObject(data);
        }
        catch(JSONException e) {
            m_data    = new String("");
            m_reader  = null;
        }
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// TEST
    ///

    /// PRIVATE

    private boolean isReaderNull () {
        return m_reader.equals(null);
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////
    ///
    /// GETTERS
    ///

    /// PRIVATE
    private String getString (String key) {
        String str = "";

        if(isReaderNull()) return str;

        try {
            str = m_reader.getString(key);
        }
        catch (JSONException e) {
            // Display errors
        }

        return str;
    }

    /// PUBLIC

    public String getJSONContent () {
        return m_data;
    }

    public String getTitle () {
       return this.getString("title");
    }

    public String getDescription () {
        return this.getString("description");
    }

    ///
    ///
    ///
    ////////////////////////////////////////////////////////
}
