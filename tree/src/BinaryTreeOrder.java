import java.util.*;

/**
 * @Description
 * @Author ZhangAohui
 * @Date 2022-12-13 14:25
 * @Description:
 */
public class BinaryTreeOrder {
    public static int num = 0;
    public static int num1 = 0;
    public static int num2 = 0;
    public static void main(String[] args) {
        Vector<Object> objects = new Vector<>();
        new ArrayDeque<>();
        LinkedList<Object> objects1 = new LinkedList<>();
        ArrayList arrayList = new ArrayList(2);
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//
//        }
//        arrayList.add("fdasdf");
//        new ArrayList<String>(arrayList);
//        System.out.println(arrayList.getClass());
//        System.out.println(ArrayList.class);
        TreeNode root = new TreeNode(new Hero(0, "根节点"));
        TreeNode node1 = new TreeNode(new Hero(1, "节点1"));
        TreeNode node2 = new TreeNode(new Hero(2, "节点2"));
        TreeNode node3 = new TreeNode(new Hero(3, "节点3"));
        TreeNode node4 = new TreeNode(new Hero(4, "节点4"));
        TreeNode node5 = new TreeNode(new Hero(5, "节点5"));
        TreeNode node6 = new TreeNode(new Hero(6, "节点6"));
        root.setLeftNode(node1);
        root.setRightNode(node2);
        node1.setLeftNode(node3);
        node1.setRightNode(node4);
        node3.setLeftNode(node5);
        node3.setRightNode(node6);

        // 前序遍历
        System.out.println("\n递归实现前序遍历：");
        preOrderTraverse1(root);
//        System.out.println("\n非递归实现前序遍历：");
//        preOrderTraverse2(root);

        // 中序遍历
        System.out.println("\n递归实现中序遍历：");
        inOrderTraverse1(root);
//        System.out.println("\n非递归实现中序遍历：");
//        inOrderTraverse2(root);

        // 中序遍历
        System.out.println("\n递归实现后序遍历：");
        postOrderTraverse1(root);
//        System.out.println("\n非递归实现后序遍历：");
//        postOrderTraverse2(root);

        System.out.println(preOrderSearch1(root, 1));
        System.out.println(num);
        System.out.println(inOrderSearch1(root, 1));
        System.out.println(num1);
        System.out.println(postOrderSearch1(root, 1));
        System.out.println(num2);

    }

    /**
     * 递归实现前序遍历
     *
     * @param root 根节点
     */
    public static void preOrderTraverse1(TreeNode root){
        if(root!=null){
            System.out.println(root.getData() + "->");
            preOrderTraverse1(root.getLeftNode());
            preOrderTraverse1(root.getRightNode());
        }
    }
    /**
     * 递归实现前序搜索
     * @param root 树的根节点
     * @param id 查询的数据的id
     * @return
     */
    public static TreeNode preOrderSearch1(TreeNode root, int id){
        if(root!=null){
            TreeNode treeNode = root;
            Hero hero = (Hero) root.getData();
            num++;
            if(hero.getId() == id){
                return treeNode;
            }
//            System.out.println(root.getData() + "->");
            treeNode = preOrderSearch1(root.getLeftNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
            treeNode = preOrderSearch1(root.getRightNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
        }
        return null;
    }
    /**
     * 递归实现中序遍历
     *
     * @param root 根节点
     */
    public static void inOrderTraverse1(TreeNode root){
        if(root!=null){
            inOrderTraverse1(root.getLeftNode());
            System.out.println(root.getData() + "->");
            inOrderTraverse1(root.getRightNode());
        }
    }
    /**
     * 递归实现中序搜索
     * @param root 树的根节点
     * @param id 查询的数据的id
     * @return
     */
    public static TreeNode inOrderSearch1(TreeNode root, int id){

        if(root!=null){

            TreeNode treeNode = root;
            treeNode = inOrderSearch1(root.getLeftNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
//            System.out.println(root.getData() + "->");
            Hero hero = (Hero) root.getData();
            num1++;
            if(hero.getId() == id){
                return root;
            }
            treeNode = inOrderSearch1(root.getRightNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
        }
        return null;
    }
    /**
     * 递归实现后序遍历
     *
     * @param root 根节点
     */
    public static void postOrderTraverse1(TreeNode root){
        if(root!=null){
            postOrderTraverse1(root.getLeftNode());
            postOrderTraverse1(root.getRightNode());
            System.out.println(root.getData() + "->");
        }
    }
    /**
     * 递归实现后序搜索
     * @param root 树的根节点
     * @param id 查询的数据的id
     * @return
     */
    public static TreeNode postOrderSearch1(TreeNode root, int id){

        if(root!=null){
            TreeNode treeNode = root;
            treeNode = postOrderSearch1(root.getLeftNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
            treeNode = postOrderSearch1(root.getRightNode(), id);
            if(treeNode!=null){
                return treeNode;
            }
            //            System.out.println(root.getData() + "->");
            Hero hero = (Hero) root.getData();
            num2++;
            if(hero.getId() == id){
                return root;
            }
        }
        return null;
    }

}

/**
 * 数节点类
 */
class TreeNode{
    /**
     * 数据域
     */
    private Object data;
    /**
     * 左孩子指针
     */
    private TreeNode leftNode;
    /**
     * 右孩子指针
     */
    private TreeNode rightNode;

    public TreeNode(Object data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
/**
 * 英雄实体类
 */
class Hero {
    /**
     * id
     */
    private int id;
    /**
     * 姓名
     */
    private String name;

    public Hero(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
