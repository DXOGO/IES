package com.dxogo.Greeting;

public class Greeting {

    private final String name;
    private final String content;

    public Greeting(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() { return this.name;}

    public String getContent() { return this.content; }

}

