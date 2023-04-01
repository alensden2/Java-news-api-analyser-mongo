package APIAssets;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String API_URL_1 = "https://newsapi.org/v2/top-headlines?q=";
    public static final String API_URL_2 = "&apiKey=";
    public static final String TITLE_REGEX_PATTERN = "\"title\":\"([^\"]+)\"";
    public static final String Content_REGEX_PATTERN = "\"content\":\"([^\"]+)\"";
    public static final int FINAL_ARTICLE_PER_FILE = 5;
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
