package com.javaReview.domain.employee;

/**
 * Created by jiangmingli on 2017/10/9.
 */
public class Employee {

    private String name;

    public Employee(Builder builder) {
        this.name = builder.name;
    }
    public Employee(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public static class Builder {
        private String name;

        public Employee build() {
            return new Employee(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }

}
