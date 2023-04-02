package CodeA;

import java.util.HashMap;
import java.util.Map;

import CodeB.CodeB;

public class CodeA {

  public void codeA() {
    Map<String, String> apiResponse = new HashMap<>();
    ExtractionEngine extractionEngine = new ExtractionEngine();
    apiResponse = extractionEngine.getExtractionEngine();

    // code b hook
    CodeB codeB = new CodeB(apiResponse);
    codeB.sendApiDataToDataProcessing();
  }
}
