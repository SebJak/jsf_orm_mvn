package com.sjk.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Sebastian on 2015-06-15.
 */
@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable{

    private String localeCode;

    private static Map<String,Object> countries;
    static{
        countries = new LinkedHashMap<String,Object>();
        countries.put("EN", Locale.ENGLISH);
        countries.put("PL", new Locale("pl","PL"));
        countries.put("DE", Locale.GERMANY);
    }

    public Map<String, Object> getCountriesInMap() {
        return countries;
    }


    public String getLocaleCode() {
        return localeCode;
    }


    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChange(String langCode){


        //loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet()) {

            if(entry.getValue().toString().equals(langCode)){
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }

    @PostConstruct
    public void init(){
        System.out.printf("-------------------INIT--------------------");
        Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
        System.out.printf(locale.getCountry());
    }

}
