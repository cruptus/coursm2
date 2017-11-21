package data;

import org.json.JSONException;

import java.util.List;
import java.util.Map;

/**
 * Created by francois-mariemanicacci on 14/11/2017.
 */

public interface Parser {
    List<Map<String, String>> getItems () throws JSONException;
}
