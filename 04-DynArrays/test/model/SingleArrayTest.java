package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingleArrayTest {
    private SingleArray getFilledArray(int size) {
        var array = new SingleArray();
        for(int i = 0; i < size; ++i)
            array.add(i);
        return array;
    }

    @Test
    void addItemInTheMiddleOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        array.add(500, 47);

        //Assert
        Assertions.assertEquals(500, array.get(47));
        Assertions.assertEquals(101, array.size());
    }

    @Test
    void removeItemFromTheMiddleOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        var value = array.remove(55);

        //Assert
        Assertions.assertEquals(56, array.get(55));
        Assertions.assertEquals(55, value);
        Assertions.assertEquals(99, array.size());
    }

    @Test
    void addItemInTheMiddleOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        array.add(500, 2);

        //Assert
        Assertions.assertEquals(500, array.get(2));
        Assertions.assertEquals(6, array.size());
    }

    @Test
    void removeItemFromTheMiddleOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        var value = array.remove(2);

        //Assert
        Assertions.assertEquals(3, array.get(2));
        Assertions.assertEquals(2, value);
        Assertions.assertEquals(4, array.size());
    }




    @Test
    void addItemInTheBeginOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        array.add(500, 0);

        //Assert
        Assertions.assertEquals(500, array.get(0));
        Assertions.assertEquals(101, array.size());
    }

    @Test
    void removeItemFromTheBeginOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        var value = array.remove(0);

        //Assert
        Assertions.assertEquals(1, array.get(0));
        Assertions.assertEquals(0, value);
        Assertions.assertEquals(99, array.size());
    }

    @Test
    void addItemInTheBeginOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        array.add(500, 0);

        //Assert
        Assertions.assertEquals(500, array.get(0));
        Assertions.assertEquals(6, array.size());
    }

    @Test
    void removeItemFromTheBeginOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        var value = array.remove(0);

        //Assert
        Assertions.assertEquals(1, array.get(0));
        Assertions.assertEquals(0, value);
        Assertions.assertEquals(4, array.size());
    }




    @Test
    void addItemInTheEndOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        array.add(500, 100);

        //Assert
        Assertions.assertEquals(500, array.get(100));
        Assertions.assertEquals(101, array.size());
    }

    @Test
    void removeItemFromTheEndOfArrayOf100Elements() {
        //Arrange
        var array = getFilledArray(100);

        //Act
        var value = array.remove(99);

        //Assert
        Assertions.assertEquals(98, array.get(98));
        Assertions.assertEquals(99, value);
        Assertions.assertEquals(99, array.size());
    }

    @Test
    void addItemInTheEndOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        array.add(500, 5);

        //Assert
        Assertions.assertEquals(500, array.get(5));
        Assertions.assertEquals(6, array.size());
    }

    @Test
    void removeItemFromTheEndOfArrayOf5Elements() {
        //Arrange
        var array = getFilledArray(5);

        //Act
        var value = array.remove(4);

        //Assert
        Assertions.assertEquals(3, array.get(3));
        Assertions.assertEquals(4, value);
        Assertions.assertEquals(4, array.size());
    }

    /*@Test
    void addElementInMiddle() {
        //Arrange
        SingleArray array = new SingleArray();
        array.add(1);
        array.add(3);
        array.add(4);

        //Act
        array.add(2, 1);

        //Assert
        Assertions.assertEquals(2, array.get(1));
        Assertions.assertEquals(4, array.size());
    }

    @Test
    void removeElementFromMiddle() {
        //Arrange
        SingleArray array = new SingleArray();
        array.add(1);
        array.add(2);
        array.add(3);

        //Act
        var value = array.remove(1);

        //Assert
        Assertions.assertEquals(3, array.get(1));
        Assertions.assertEquals(2, value);
        Assertions.assertEquals(2, array.size());
    }*/
}