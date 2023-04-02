package org.example;

import CodeA.CodeA;
import CodeA.ExtractionEngine;
import CodeC.CodeC;

/**
 * This is a Java Application that fetches data from a news api (https://newsapi.org/docs/endpoints/top-headlines)
 * And then processes the data by restricting the articles to five per keyword. It then processes it to remove any special
 * Characters and emoticons and stores it in a NOSQL MongoDB Database.
 *
 * @author Alen John
 * @version 1.0
 * @since Apr 02, 2023
 *
 * @see Java Docs reference - "https://www.tutorialspoint.com/java/java_documentation.htm"
 */
public class Main {

  public static void main(String[] args) {
    /**
     * RUN APPLICATION FROM HERE
     * Initiate Code A
     */
    CodeA codeA = new CodeA();
    codeA.codeA();
  }
}
