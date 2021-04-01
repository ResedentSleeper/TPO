import edu.btree.BTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class BTreeTest {

    private ArrayList<Integer> values = new ArrayList<>();
    BTree bt = new BTree();

    @Before
    public void setUp() {
        for (int i=0; i < 8; i++){
            int k = (int) (Math.random()*10);
            bt.insertValue(k+i);
        }
        bt.printTree();
    }


    @Test
    public void whenAddOneElementTwice() {
        Assert.assertEquals(bt.insertValue(110), true);
        bt.insertValue(110);
        Assert.assertEquals(bt.insertValue(110), false);
        bt.printTree();
    }

    @Test
    public void whenDeleteExistentElement() {
        bt.insertValue(110);
        bt.printTree();
        Assert.assertEquals(bt.deleteValue(110), true);
        bt.deleteValue(110);
        bt.printTree();
    }

    @Test
    public void whenDeleteInexistentElement() {
        Assert.assertEquals(bt.deleteValue(110), false);
        bt.printTree();
    }

}
