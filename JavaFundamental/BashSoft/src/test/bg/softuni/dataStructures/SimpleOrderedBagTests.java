package test.bg.softuni.dataStructures;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.interfaces.SimpleOrderedBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        this.names = new SimpleSortedList<>(String.class);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialCapacity() {
        this.names = new SimpleSortedList<>(String.class, 20);
        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialComparer() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithAllParams() {
        this.names = new SimpleSortedList<String>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddShouldIncreaseTheSize() {
        this.names.add("Nasko");
        Assert.assertEquals(1, this.names.size());
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");
        List<String> expected = new ArrayList<>();
        expected.add("Rosen");
        expected.add("Georgi");
        expected.add("Balkan");
        Collections.sort(expected);

        int index = 0;
        for (String name : names) {
            Assert.assertEquals(expected.get(index), name);
            index++;
        }
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        List<String> list = new ArrayList<>();
        list.add("Rosen");
        list.add("Georgi");

        this.names.addAll(list);
        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException() {
        this.names.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted() {
        List<String> expected = new ArrayList<>();
        expected.add("Rosen");
        expected.add("Georgi");
        expected.add("Balkan");
        this.names.addAll(expected);

        Collections.sort(expected);

        int index = 0;
        for (String name : names) {
            Assert.assertEquals(expected.get(index), name);
            index++;
        }

    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");

        this.names.remove("Rosen");
        Assert.assertEquals(2, this.names.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        this.names.add("Rosen");
        this.names.add("Georgi");

        Assert.assertTrue(this.names.remove("Rosen"));
        Assert.assertFalse(this.names.remove("Rosen"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException(){
        this.names.add("Rosen");
        this.names.add("Georgi");

        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull(){
        this.names.add("Rosen");
        this.names.add("Georgi");

        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine(){
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");

        String actual = this.names.joinWith(", ");
        String expected = "Balkan, Georgi, Rosen";

        Assert.assertEquals(expected, actual);
    }
}
