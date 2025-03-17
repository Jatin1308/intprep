package VariablesAndDatatypes;

public class Main {

    public static void main(String[] args) {

        var anyObj = "Hello";

        /*anyObj = 10; // -> this will give error because earlier we have used it as string*/
        // therefore still is statically typed language



        // why does java has 2byte char but in c/c++ we have 1byte char?
        /*
            because java uses unicode system which supports characters from all languages
            example -> Latin/Greek/Chinese, which needs 2bytes/16bits for representation

            by contrast c/c++ uses 1 byte, supporting only 256 characters
         */

        // instance and static variables can be defined and might not be initialized because they get default value
        // when declared

        // local variables should be initialized as well as they do not get default value
    }
}
