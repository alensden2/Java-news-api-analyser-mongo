package CodeB;

import java.util.Map;

public class CodeB {
    Map<String,String> API_DATA;
    public CodeB(Map<String, String> apiData) {
        API_DATA = apiData;
    }

    public void sendApiDataToDataProcessing(){
        DataProcessing dataProcessing = new DataProcessing();
        dataProcessing.findFiveArticlesForKeywords(API_DATA);
    }

}
