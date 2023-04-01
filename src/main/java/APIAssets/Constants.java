package APIAssets;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String API_URL_1 = "https://newsapi.org/v2/top-headlines?q=";
    public static final String API_URL_2 = "&apiKey=";
    /**
     * FORMAT TO USE API STRING -
     * API_CALLED = API_URL_1+NEWS-HEADLINE+API_URL_2+API-KEY
     * */
    public static final List<String> SEARCH_KEYWORDS = Arrays.asList(
            "Canada", "University", "Dalhousie", "Halifax",
            "Canada Education", "Moncton", "hockey", "Fredericton",
            "celebration"
    );
}
