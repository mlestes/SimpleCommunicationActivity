package com.coolcats.estesfuntimes;

import android.app.Application;

public class StoredValue extends Application {

    private String previousValueOne = null;
    private String previousValueTwo = null;

    public void setPreviousValueOne(String str){previousValueOne = str;}
    public void setPreviousValueTwo(String str){previousValueTwo = str;}
    public String getPreviousValueOne(){return previousValueOne;}
    public String getPreviousValueTwo(){return previousValueTwo;}

}
