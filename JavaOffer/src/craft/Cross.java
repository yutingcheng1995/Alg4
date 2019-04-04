package craft;

import java.util.ArrayList;
import java.util.Arrays;

public class Cross {
    int cid;
    int[] rids = new int[4];

    public Cross(ArrayList<Integer> crosses) {
        this.cid = crosses.get(0);
        this.rids[0] =  crosses.get(1);
        this.rids[1] =  crosses.get(2);
        this.rids[2] =  crosses.get(3);
        this.rids[3] =  crosses.get(4);
    }

    public int getCid() {
        return cid;
    }

    public int[] getRids() {
        return rids;
    }

    @Override
    public String toString() {
        return "Cross{" +
                "cid=" + cid +
                ", rids=" + Arrays.toString(rids) +
                '}';
    }
}
