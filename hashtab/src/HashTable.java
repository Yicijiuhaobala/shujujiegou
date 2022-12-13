package hashtab;

/**
 * @Description
 * @Author ZhangAohui
 * @Date 2022-12-02 11:16
 * @Description: 数组+链表实现哈希表
 * */
public class HashTable {
    public static void main(String[] args) {
        HashTables hashTables = new HashTables(4);
        hashTables.add(new Emp(0, "张0"));
        hashTables.add(new Emp(1, "张1" ));
        hashTables.add(new Emp(2, "张2"));
        hashTables.add(new Emp(3, "张3"));
        hashTables.add(new Emp(4, "张4"));
        hashTables.add(new Emp(5, "张5"));
        hashTables.add(new Emp(8, "张8"));
        hashTables.add(new Emp(16, "张16"));
        hashTables.add(new Emp(12, "张12"));
        hashTables.showHashTable();
        System.out.println(hashTables.findEmp(31));
    }
}
class Emp {
    private int id;
    private String name;
    private Emp next;

    public Emp(int id, String name) {
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

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class EmpLinkedList{
    private Emp head;
    public void addEmp(Emp emp){
        if(head == null){
            head = emp;
            return;
        }
        Emp temp = head;
        if(head.getId()> emp.getId()){
            head = emp;
            emp.setNext(temp);
            return;
        }
//        Emp temp_next = null;
        while(true){
            if (temp.getNext() != null){
                if(temp.getId()<emp.getId() && emp.getId()< temp.getNext().getId()){
                    emp.setNext(temp.getNext());
                    temp.setNext(emp);
//                emp.setNext(temp.getNext());
                    return;
                }
            }else {
                temp.setNext(emp);
                return;
            }
            temp = temp.getNext();
        }
//        while(true){
//            if(temp.getNext() == null){
//                break;
//            }
//            temp = temp.getNext();
//        }
//        temp.setNext(emp);
    }
    public void showEmpLinkList(int index){
        if(head == null){
            System.out.println("第" + index + "条链表为空");
//            System.out.println("链表为空");
            return;
        }
        System.out.println("第" + index + "条链表数据:-------------");
        Emp temp = head;
        while(temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
    public Emp findEmp(int id){
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while(true){
            if(id == temp.getId()){
                return temp;
            }else if(temp.getNext() == null){
                System.out.println("未找到数据");
                return null;
            }
            temp = temp.getNext();
        }
    }
}
class HashTables{
    private EmpLinkedList[] empLinkedListsArray;

    public HashTables(int size) {
        this.empLinkedListsArray = new EmpLinkedList[size];
//        初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    public EmpLinkedList[] getEmpLinkedListsArray() {
        return empLinkedListsArray;
    }

    public void setEmpLinkedListsArray(EmpLinkedList[] empLinkedListsArray) {
        this.empLinkedListsArray = empLinkedListsArray;
    }
    public void add(Emp emp){
        int id = emp.getId();
        int index = id%(empLinkedListsArray.length);
        empLinkedListsArray[index].addEmp(emp);
    }
    public Emp findEmp(int id){
        int index = id%(empLinkedListsArray.length);
        return empLinkedListsArray[index].findEmp(id);
    }
    public void showHashTable(){
        int index = 0;
        for (EmpLinkedList empLinkedList:
                empLinkedListsArray) {
//            System.out.println("链表index: " + index + "----------------");
            empLinkedList.showEmpLinkList(index);
            index++;
        }
    }
}
