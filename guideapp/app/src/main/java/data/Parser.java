package data;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by francois-mariemanicacci on 14/11/2017.
 */

public interface Parser {
    String getRawData ();
    JSONObject getJSON ();
    JSONArray getJSONArray ();
    JSONObject getJSONItem (int index);
}
