package javaOOPBasics.eliDemo.commandDispatcher;

import javaOOPBasics.eliDemo.exceptions.MyException;

public class SecondDispatcher implements DispatchCommand{


    @Override
    public String dipatch() {
        throw new MyException("My exception");
    }

}
