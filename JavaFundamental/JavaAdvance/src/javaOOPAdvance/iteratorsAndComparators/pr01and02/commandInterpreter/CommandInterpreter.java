package javaOOPAdvance.iteratorsAndComparators.pr01and02.commandInterpreter;

import javaOOPAdvance.iteratorsAndComparators.pr01and02.factory.ListyIteratorFactory;
import javaOOPAdvance.iteratorsAndComparators.pr01and02.factory.ListyIteratorFactoryImpl;
import javaOOPAdvance.iteratorsAndComparators.pr01and02.listyIterator.ListyIterator;

import java.util.NoSuchElementException;

public class CommandInterpreter {
    private ListyIterator listyIterator;
    private ListyIteratorFactory listyIteratorFactory;

    public CommandInterpreter() {
        this.listyIteratorFactory = new ListyIteratorFactoryImpl();
    }

    public void execute(String commands) {
        String[] tokens = commands.split("\\s+");
        switch (tokens[0].toLowerCase()) {
            case "create":
                this.listyIterator = listyIteratorFactory.create(tokens);
                break;
            case "move":
                System.out.println(this.listyIterator.move());
                break;
            case "print":
                try {
                    this.listyIterator.print();
                } catch (NoSuchElementException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "hasnext":
                System.out.println(this.listyIterator.hasNext());
                break;
            case "printall":
                this.listyIterator.printAll();
                break;
        }
    }
}
