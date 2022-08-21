package OTUSHomework;

import org.junit.Assert;
import org.junit.Test;

public class PQueueTest {

    @Test
    public void enqueue_one_element() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int add = 50;

        //Act
        pQueue.enqueue(1, add);
        int ret = pQueue.dequeue();

        //Assert
        Assert.assertEquals(add, ret);
    }

    @Test
    public void enqueue_two_elements_with_same_priority() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;

        //Act
        pQueue.enqueue(2, first);
        pQueue.enqueue(2, second);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();

        //Assert
        Assert.assertEquals(first, ret_first);
        Assert.assertEquals(second, ret_second);
    }

    @Test
    public void enqueue_two_elements_with_different_priorities() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;

        //Act
        pQueue.enqueue(1, first);
        pQueue.enqueue(2, second);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();

        //Assert
        Assert.assertEquals(second, ret_first);
        Assert.assertEquals(first, ret_second);
    }

    @Test
    public void enqueue_three_elements_with_different_priorities() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;
        int third = 150;

        //Act
        pQueue.enqueue(1, first);
        pQueue.enqueue(3, second);
        pQueue.enqueue(2, third);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();
        int ret_third = pQueue.dequeue();

        //Assert
        Assert.assertEquals(second, ret_first);
        Assert.assertEquals(third, ret_second);
        Assert.assertEquals(first, ret_third);
    }

    @Test
    public void enqueue_two_elements_with_same_priorities_and_one_element_with_less_priority() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;
        int third = 150;

        //Act
        pQueue.enqueue(2, first);
        pQueue.enqueue(2, second);
        pQueue.enqueue(1, third);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();
        int ret_third = pQueue.dequeue();

        //Assert
        Assert.assertEquals(first, ret_first);
        Assert.assertEquals(second, ret_second);
        Assert.assertEquals(third, ret_third);
    }

    @Test
    public void enqueue_one_element_with_less_priority_and_two_elements_with_same_priorities() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;
        int third = 150;

        //Act
        pQueue.enqueue(1, first);
        pQueue.enqueue(2, second);
        pQueue.enqueue(2, third);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();
        int ret_third = pQueue.dequeue();

        //Assert
        Assert.assertEquals(second, ret_first);
        Assert.assertEquals(third, ret_second);
        Assert.assertEquals(first, ret_third);
    }

    @Test
    public void enqueue_two_elements_with_same_priorities_and_one_element_with_greater_priority() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;
        int third = 150;

        //Act
        pQueue.enqueue(2, first);
        pQueue.enqueue(2, second);
        pQueue.enqueue(3, third);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();
        int ret_third = pQueue.dequeue();

        //Assert
        Assert.assertEquals(third, ret_first);
        Assert.assertEquals(first, ret_second);
        Assert.assertEquals(second, ret_third);
    }

    @Test
    public void enqueue_one_element_with_greater_priority_and_two_elements_with_same_priorities() {
        //Arrange
        PQueue<Integer> pQueue = new PQueue<>();
        int first = 50;
        int second = 100;
        int third = 150;

        //Act
        pQueue.enqueue(3, first);
        pQueue.enqueue(2, second);
        pQueue.enqueue(2, third);
        int ret_first = pQueue.dequeue();
        int ret_second = pQueue.dequeue();
        int ret_third = pQueue.dequeue();

        //Assert
        Assert.assertEquals(first, ret_first);
        Assert.assertEquals(second, ret_second);
        Assert.assertEquals(third, ret_third);
    }
}