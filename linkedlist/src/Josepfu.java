/**
 * @author Zah
 * @create 2022-11-25 16:57
 * @Description
 */

/**
 * 解决约瑟夫问题
 * @author 22130
 */
public class Josepfu {
    public static void main(String[] args) {
        // 测试构建环形链表和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 加入7个小孩
        circleSingleLinkedList.addBoy(7);
        circleSingleLinkedList.showBoy();

        // 测试小孩出圈 3->6->2->7->5->1->4
        circleSingleLinkedList.countBoy(1, 3, 7);
    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = null;

    /**
     * 添加小孩节点，构建一个环形链表
     * @param nums
     */
    public void addBoy(int nums) {
        // nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
        }
        // 辅助指针，帮助构建环形链表
        Boy temp = null;
        // 使用for来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号，创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                // 让temp指向第一个小孩
                temp = first;
            } else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~");
            return;
        }
        // 因为first不能动，所以我们还需要使用一个辅助指针完成遍历
        Boy temp = first;
        while (true) {
            System.out.printf("小孩的编号%d \n", temp.getNo());
            // 说明遍历完毕
            if (temp.getNext() == first){
                break;
            }
            // temp后移
            temp = temp.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     * @param firstNo 表示小孩从第几个小孩开始报数
     * @param countNum 表示一次数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int firstNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || firstNo < 1 || firstNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建辅助指针
        Boy helper = first;
        // 需求创建一个辅助指针变量helper，事先应该指向环形链表的最后这个节点
        while (true) {
            // 说明helper指向了最后小孩节点
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前，先让first和helper移动firstNo-1次
        for (int j = 0; j < firstNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时，，让first和helper指针同时移动m-1此，然后出圈
        while (true) {
            // 说明圈中只有一节点
            if (helper == first) {
                break;
            }
            // 让first和helper指针同时的移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点，就是小孩要出圈的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            // 这是将first指向的小孩出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d\n", first.getNo());
    }

}

/**
 * 创建一个Boy类，表示一个节点
 */
class Boy {
    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点，默认为null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


