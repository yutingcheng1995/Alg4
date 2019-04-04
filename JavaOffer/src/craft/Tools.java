package craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tools {
    public static ArrayList<ArrayList<Integer>> readFile(BufferedReader fr) throws IOException {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        String data = null;
        while((data = fr.readLine())!=null){
            //System.out.println(data);
            if(data.charAt(0)=='('){
                data = data.replace("(","");
                data = data.replace(")","");
                System.out.println(data);
                String[] strs = data.split(", ");
                ArrayList<Integer> list = new ArrayList<>();
                for(int k = 0; k < strs.length; k++){
                    list.add(Integer.parseInt(strs[k]));
                }
                res.add(new ArrayList<>(list));
            }
        }
        fr.close();
        for(int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        return res;
    }
}
