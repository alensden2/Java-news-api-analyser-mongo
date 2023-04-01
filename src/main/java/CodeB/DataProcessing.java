package CodeB;

import APIAssets.Constants;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataProcessing {

    DataProcessing ()  {
        WriteToFile writeToFile = new WriteToFile();
    }

    List<String> keywords = Constants.SEARCH_KEYWORDS;

    public void findFiveArticlesForKeywords(Map<String, String> apiData) {
        for (String s : keywords) {
            getTitleContent(apiData.get(s));
        }
    }

    // add to file logic left
    // change to
    public String getTitleContent(String api_response) {
        Pattern titleExtractionRegex = Pattern.compile(Constants.TITLE_REGEX_PATTERN);
        Pattern contentExtractionRegex = Pattern.compile(Constants.Content_REGEX_PATTERN);
        Matcher titleMatcher = titleExtractionRegex.matcher(api_response);
        Matcher contentMatcher = contentExtractionRegex.matcher(api_response);
        while (titleMatcher.find() && contentMatcher.find()) {
            String content = contentMatcher.group(1);
            String title = titleMatcher.group(1);
            if (content != null || !content.isEmpty()) {
                System.out.println("Title: " + title);
                System.out.println("Content: " + content);
            }
        }


        return "    ";
    }
}
