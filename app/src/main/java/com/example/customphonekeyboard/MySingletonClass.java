package com.example.customphonekeyboard;

public class MySingletonClass {
    private static MySingletonClass instance;

    public static MySingletonClass getInstance() {
        if (instance == null)
            instance = new MySingletonClass();
        return instance;
    }

    private MySingletonClass() {
    }

    private String intValue;

    public String getStringValue() {
        return intValue;
    }

    public void setString(String intValue) {
        this.intValue = intValue;
    }
}
