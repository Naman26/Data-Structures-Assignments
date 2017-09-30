
/**
 * Write a description of class BSTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BSTree
{
    int key;
    BSTree leftChild;
    BSTree rightChild;
    
    BSTree(int key){
        this.key=key;
    }
    
    public String toString(){
        return key+"";
    }
}
