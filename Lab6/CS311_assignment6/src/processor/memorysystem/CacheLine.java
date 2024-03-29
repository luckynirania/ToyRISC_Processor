package processor.memorysystem;

import generic.*;
import processor.*;

public class CacheLine{
    int[] tag = new int[2]; 
    // int index;
    int[] data = new int[2];
    int lru;

    public CacheLine()
	{   
        // this.index = index;
        this.tag[0] = -1;
        this.tag[1] = -1;
        this.lru =0;
    }
    public void setValue(int tag, int value) {
        if(tag == this.tag[0]) {
            this.data[0] = value;
            this.lru = 1;
        }
        else if(tag == this.tag[1]) {
            this.data[1] = value;
            this.lru = 0;
        }

        else {
            this.tag[this.lru] = tag;
            this.data[this.lru] = value;
            this.lru = 1- this.lru;
        }
	}
}