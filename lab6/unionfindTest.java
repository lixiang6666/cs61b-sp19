import org.junit.*;
public class unionfindTest {
    @Test public void test(){
        UnionFind uf = new UnionFind(5);
        uf.union(1,2);
        System.out.println(uf.find(1));
        Assert.assertTrue(uf.find(1) ==2);
        uf.union(3,4);
        Assert.assertFalse(uf.connected(1,3));
        Assert.assertTrue(uf.connected(2,1));
        uf.union(2,0);
        Assert.assertFalse(uf.find(0) == uf.find(4));
        //uf.union(3,0);
        System.out.println(uf.parent(1));
        System.out.println(uf.parent(2));
        System.out.println(uf.parent(0));
        System.out.println(uf.parent(3));
        System.out.println(uf.parent(4));
        uf.union(1,3);
        System.out.println(uf.parent(3));
        System.out.println(uf.parent(4));
        uf.find(3);
        System.out.println(uf.parent(3));
    }

}
