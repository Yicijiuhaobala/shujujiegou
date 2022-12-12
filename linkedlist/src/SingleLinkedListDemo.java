/**
 * @author Zah
 * @create 2022-11-23 14:22
 * @Description
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode1 her01 = new HeroNode1(1, "宋江", "及时雨");
        HeroNode1 her02 = new HeroNode1(2, "卢俊义", "玉麒麟");
        HeroNode1 her03 = new HeroNode1(3, "吴用", "智多星");
        HeroNode1 her04 = new HeroNode1(4, "林冲", "豹子头");
        HeroNode1 her05 = new HeroNode1(3, "冲", "豹头");
        SingleLinkedList1 singleLinkedList1 = new SingleLinkedList1();
        singleLinkedList1.addByOrder(her01);
        singleLinkedList1.addByOrder(her03);
        singleLinkedList1.addByOrder(her02);
        singleLinkedList1.addByOrder(her04);
        singleLinkedList1.addByOrder(her05);
        singleLinkedList1.showList();
    }
}
//定义SingleLinkedList管理单链表
class SingleLinkedList1 {
//    初始化头节点
    private HeroNode1 head = new HeroNode1(0, "", "");
//
//    添加节点到单向链表
//    1.找到当前链表的最后节点
//    2.将最后这个节点的next指向新的节点
    public void add(HeroNode1 heroNode1){
        HeroNode1 temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode1;
    }
//    按照节点的标号顺序进行添加
//    如果添加时已经存在该编号，则进行覆盖修改
    public void addByOrder(HeroNode1 heroNode1){
//        链表之前为空时直接进行添加
        if(head.next == null){
            head.next = heroNode1;
            return;
        }
         HeroNode1 temp = head.next;
         boolean flag = false;// 标志是否存在该编号
         while (true){
             if(temp == null){
                 break;
             }
             if(temp.no< heroNode1.no && (temp.next==null || heroNode1.no<temp.next.no)){
                 heroNode1.next = temp.next;
                 temp.next = heroNode1;
                return;
             }
             if(temp.no == heroNode1.no){
                 temp.nickname = heroNode1.nickname;
                 temp.name = heroNode1.name;
//                 heroNode1.next = temp.next;
//                 temp = heroNode1;
//                 System.out.println(temp);
//                 System.out.println(heroNode1);
                 System.out.print("已经存在该标号节点" + heroNode1.no + "，无法进行添加" + "   ");
                 System.out.println("该节点为" + heroNode1);
                 return;
             }
             temp = temp.next;
         }
    }
    public void showList(){
        if(head.next == null){
            System.out.println("链表为空，退出");
            return;
        }
        HeroNode1 temp = head.next;
        while (true){
            System.out.println(temp);
            if(temp.next == null){
                System.out.println("链表展示完毕，退出");
                return;
            }
            temp = temp.next;
        }
    }
}
//    定义heroNode，每个HeroNode对象就是一个节点
class HeroNode1 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next; // 指向下一个节点

//    构造器
    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }
}
