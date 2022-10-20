package edu.naeemaziz.namesearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Age {

    @JsonProperty("age")
    public int age;

    @JsonProperty("count")
    public int count;

    @JsonProperty("name")
    public String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
