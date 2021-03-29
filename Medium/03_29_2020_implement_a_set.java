import java.util.Collections;
import java.util.List;
import java.util.Map;

class CustomSet {

    private List<Integer> list;
    // Map values to their index
    private Map<Integer, Integer> map;
    public CustomSet() {

        this.list = new ArrayList<>();
        this.map = new HashMap<>();

    }

    // Implement adding

    public void add(int ele) {
        if (map.containsKey(ele)) return;
        // If the element is not present
        int index = list.size();
        this.list.add(ele);
        // add to map
        this.map.put(ele, index);
    }

    public void remove(int ele) {
        // Index of element
        Integer index = this.map.get(ele);
        if (index == null) {
            return;
        }
        // remove it
        this.map.remove(ele);

        // get the size of the array list
        int size = this.list.size();
        Integer last = this.list.get(size - 1);
        Collections.swap(this.list, size - 1, index);

        // remove the last element
        this.list.remove(size - 1);
        this.map.put(last, index);
    }
    public int getRandom() {
        int rand = (int) Math.random() * this.list.size();
        return this.list.get(rand);
    }
    // return the index of the lement if it is present
    public int search(int x) {
        if (this.map.containsKey(x)) {
            return map.get(x);
        }
        return -1;
    }
}