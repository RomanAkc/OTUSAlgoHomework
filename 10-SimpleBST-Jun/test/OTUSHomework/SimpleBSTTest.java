package OTUSHomework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBSTTest {
    private SimpleBST createTree() {
        //                      20
        //        15                        25
        //   5          18            23          35
        //3    12    17    19      22    24    34    36

        SimpleBST bst = new SimpleBST();

        bst.insert(20);
        bst.insert(15);
        bst.insert(25);
        bst.insert(5);
        bst.insert(18);
        bst.insert(23);
        bst.insert(35);
        bst.insert(3);
        bst.insert(12);
        bst.insert(17);
        bst.insert(19);
        bst.insert(22);
        bst.insert(24);
        bst.insert(34);
        bst.insert(36);

        return  bst;
    }

    @Test
    void check_value_is_in_tree() {
        //Arrange
        SimpleBST tree = createTree();

        //Act/Assert
        assertTrue(tree.search(20));
        assertTrue(tree.search(15));
        assertTrue(tree.search(25));
        assertTrue(tree.search(5));
        assertTrue(tree.search(18));
        assertTrue(tree.search(23));
        assertTrue(tree.search(35));
        assertTrue(tree.search(3));
        assertTrue(tree.search(12));
        assertTrue(tree.search(17));
        assertTrue(tree.search(19));
        assertTrue(tree.search(22));
        assertTrue(tree.search(24));
        assertTrue(tree.search(34));
        assertTrue(tree.search(36));
    }

    @Test
    void check_value_is_not_in_tree() {
        //Arrange
        SimpleBST tree = createTree();

        //Act/Assert
        assertFalse(tree.search(16));
        assertFalse(tree.search(1));
        assertFalse(tree.search(40));
    }

    @Test
    void remove_value_not_exists() {
        //Arrange
        SimpleBST tree = createTree();

        //Act
        tree.remove(555);

        //Assert
        assertFalse(tree.search(555));
    }

    @Test
    void remove_value_from_empty_tree() {
        //Arrange
        SimpleBST tree = new SimpleBST();

        //Act
        tree.remove(555);

        //Assert
        assertFalse(tree.search(555));
    }

    @Test
    void remove_value_without_children_from_top() {
        //Arrange
        SimpleBST tree = new SimpleBST();
        tree.insert(25);

        //Act
        tree.remove(25);

        //Assert
        assertFalse(tree.search(25));
    }

    @Test
    void remove_value_without_children() {
        //Arrange
        SimpleBST tree = createTree();

        //Act
        tree.remove(36);
        tree.remove(3);
        tree.remove(19);

        //Assert
        assertFalse(tree.search(36));
        assertFalse(tree.search(3));
        assertFalse(tree.search(19));
    }

    @Test
    void remove_value_with_one_child_grandPa_right_father_left_son() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(36);

        //25
        //      35
        //  34

        //Act
        tree.remove(35);

        //Assert
        assertFalse(tree.search(35));
        assertTrue(tree.search(34));
    }

    @Test
    void remove_value_with_one_child_grandPa_right_father_right_son() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(34);

        //25
        //   35
        //      36

        //Act
        tree.remove(35);

        //Assert
        assertFalse(tree.search(35));
        assertTrue(tree.search(36));
    }

    @Test
    void remove_value_with_one_child_grandPa_left_father_left_son() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(24);

        //      25
        //   23
        //22

        //Act
        tree.remove(23);

        //Assert
        assertFalse(tree.search(23));
        assertTrue(tree.search(22));
    }

    @Test
    void remove_value_with_one_child_grandPa_left_father_right_son() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(22);

        //      25
        //23
        //   24

        //Act
        tree.remove(23);

        //Assert
        assertFalse(tree.search(23));
        assertTrue(tree.search(24));
    }

    @Test
    void remove_value_with_one_child_from_top_father_right_son() {
        //Arrange
        SimpleBST tree = new SimpleBST();
        tree.insert(25);
        tree.insert(35);

        //25
        //   35

        //Act
        tree.remove(25);

        //Assert
        assertFalse(tree.search(25));
        assertTrue(tree.search(35));
    }

    @Test
    void remove_value_with_one_child_from_top_father_left_son() {
        //Arrange
        SimpleBST tree = new SimpleBST();
        tree.insert(25);
        tree.insert(15);

        //   25
        //15

        //Act
        tree.remove(25);

        //Assert
        assertFalse(tree.search(25));
        assertTrue(tree.search(15));
    }

    @Test
    void remove_value_with_two_children_max_right_without_child() {
        //Arrange
        SimpleBST tree = createTree();

        //Act
        tree.remove(25);

        //Assert
        assertFalse(tree.search(25));
    }

    @Test
    void remove_value_with_two_children_min_right_with_child() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(25);

        //Act
        tree.remove(34);

        //Assert
        assertFalse(tree.search(25));
    }

    @Test
    void remove_value_with_two_children_from_top_min_right_with_child() {
        //Arrange
        SimpleBST tree = createTree();

        //Act
        tree.remove(20);

        //Assert
        assertFalse(tree.search(20));
    }

    @Test
    void remove_value_with_two_children_max_left_with_child() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(25);
        tree.remove(23);
        tree.remove(35);
        tree.remove(22);
        tree.remove(24);
        tree.remove(34);
        tree.remove(36);

        //Act
        tree.remove(15);

        //Assert
        assertFalse(tree.search(15));
    }

    @Test
    void remove_value_with_two_children_from_top_max_left_with_child() {
        //Arrange
        SimpleBST tree = createTree();
        tree.remove(25);
        tree.remove(23);
        tree.remove(35);
        tree.remove(22);
        tree.remove(24);
        tree.remove(34);
        tree.remove(36);

        //Act
        tree.remove(20);

        //Assert
        assertFalse(tree.search(20));
    }
}