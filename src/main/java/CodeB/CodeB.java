package CodeB;

import java.util.Map;

import CodeC.CodeC;

public class CodeB {
  Map<String, String> API_DATA;

  public CodeB(Map<String, String> apiData) {
    API_DATA = apiData;
  }

  public void sendApiDataToDataProcessing() {
    DataProcessing dataProcessing = new DataProcessing();
    dataProcessing.findFiveArticlesForKeywords(API_DATA);
    initiateCodeC();
  }

  /**
   * Initiate code C*/
  public void initiateCodeC(){
    CodeC codeC = new CodeC();
    codeC.runTransformationEngine();
  }
}
