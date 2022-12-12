/**
 * @author Zah
 * @create 2022-11-25 15:35
 * @Description
 */

public class DoubleLinkedListDemo1 {
    public static void main(String[] args) {
        HeroNode2 her1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 her2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 her3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 her4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 her6 = new HeroNode2(6, "林", "豹子");
        HeroNode2 her5 = new HeroNode2(5, "dsd", "dsadsdsdad");
        // 创建一个双向链表对象
        DoubleLinkedList1 doubleLinkedList = new DoubleLinkedList1();
        doubleLinkedList.addByOrder(her1);
        doubleLinkedList.addByOrder(her2);
        doubleLinkedList.addByOrder(her3);
        doubleLinkedList.addByOrder(her4);
        doubleLinkedList.addByOrder(her6);
        doubleLinkedList.addByOrder(her5);
        doubleLinkedList.delete(2);
        doubleLinkedList.showList();
    }
}
class DoubleLinkedList1{
    private HeroNode2 head = new HeroNode2(0,"","");
// 得到双向链表的头
    public HeroNode2 getHead() {
        return head;
    }
//    显示双向列表
    public void showList(){
        if(head.next == null){
            System.out.println("链表为空，退出");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            System.out.println(temp);
            if(temp.next == null){
                System.out.println("链表展示完毕，退出");
                return;
            }
            temp = temp.next;
        }
    }
//    可以进行链表的顺序插入 当插入的链表的节点no与之前一样，覆盖之前的节点信息，相当于更新链表
    public void addByOrder(HeroNode2 heroNode2){
        if(head.next == null){
            head.next = heroNode2;
            heroNode2.pre = head;
            return;
        }
        HeroNode2 temp = head.next;

        while(true){
            if(temp.no<heroNode2.no && (temp.next == null || heroNode2.no<temp.next.no)){
                if(temp.next != null) {
                    HeroNode2 temp_next = temp.next;
                    heroNode2.next = temp_next;
                    temp_next.pre = heroNode2;
                }
                heroNode2.pre = temp;
                temp.next = heroNode2;
                return;
            }
            if(temp.no == heroNode2.no){
                temp.name = heroNode2.name;
                temp.nickname = heroNode2.nickname;
                return;
            }
            temp = temp.next;
        }
    }
    public void delete(int no){
        if(head.next == null){
            System.out.println("链表为空，不能删除链表");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp.no == no){
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                return;
            }
            temp = temp.next;
        }

    }
//
}
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;   // 前一个节点
    public HeroNode2 pre;   // 前一个节点

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
