package kud;

import java.util.*;


public class LanguagesController {

    private Map supportedLanguages;
    private static ResourceBundle translation;
    
    
    
    public LanguagesController(String language){
        Locale Spanish = new Locale("es", "ES");
        Locale Euskera = new Locale("eu","ES");
        supportedLanguages = new HashMap();
        supportedLanguages.put("Euskera", Euskera);
        supportedLanguages.put("Español", Spanish);
        translation = ResourceBundle.getBundle("lang", (Locale)supportedLanguages.get(language));
    }

    public String getWord(String keyword){
        return translation.getString(keyword);
    }
}


