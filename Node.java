
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    int value;
    Node leftChild;
    Node rightChild;
    public Node(int value){
        this.value= value;
    }
    
    public void insert(int data){
        if(data <= value){
            if(leftChild == null){
                leftChild= new Node(data);
            }else {
                leftChild.insert(data);
            }
        }else {
            if(rightChild==null){
                rightChild= new Node(data);
            }else {
                rightChild.insert(data);
            }
        }
    }
        
//     public boolean contains(int data){
//         if(data == value)
//             return true;
//         else if(data< value){
//             if(leftChild == null){
//                 return false;
//             }else {
//                 return leftChild.contains(data);
//             }
//         }
//         else {
//             if(rightChild == null){
//                 return false;
//             }else {
//                 return rightChild.contains(data);
//             }
//         }
//     }
    
    public void iOTraversal(){
        if(leftChild != null){
            leftChild.iOTraversal();
        }
        System.out.println(value);
        if(rightChild != null){
            rightChild.iOTraversal();
        }
    }
    
    public static void main(String[]args){
        int a[]= {8,10,5,8,1};
        Node b= new Node(a[0]);
        for(int i=1; i<5 ;i++){
            //System.out.print(a[i]+" ");
            b.insert(a[i]);
        }
        b.iOTraversal();
    }
}

