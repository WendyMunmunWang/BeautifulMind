import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collections;
/**
 * Created by wendywang on 2017-08-31.
 */
public class MinStack {
    /** initialize your data structure here. */
    private List<Integer> array;
    private int min;
    public MinStack() {
        array = new ArrayList<>();
    }

    public void push(int x) {
        if (this.array.size() == 0){
            this.min = x;
        }
        else {
            if (x < this.min) {
                this.min = x;
            }
        }
        this.array.add(x);
    }

    public void pop() {
        int pop_item = array.get(array.size()-1);
        //check if there's another item that has the same value as min
        this.array.remove(array.size()-1);
        if (pop_item == this.min  && this.array.size()>0 ){
            this.min = Collections.min(this.array);
        }
    }

    public int top() {
        return this.array.get(array.size()-1);
    }

    public int getMin() {
        return this.min;
    }
}
