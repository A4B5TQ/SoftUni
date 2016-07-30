package solidPrinciples.interfaceSegregation.badSolutions.worker;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Robot implements Worker {

    @Override
    public void eat() {
        throw new NotImplementedException();
    }

    @Override
    public void sleep() {
        throw new NotImplementedException();
    }

    @Override
    public void work() {
        //work
    }
}
