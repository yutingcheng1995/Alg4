package craft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Init{
    //泛型方法需要声明
    public static<T> ArrayList<T> InitRun(String FilePath,String str) throws IOException {
        BufferedReader fileR = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath)));
        ArrayList<ArrayList<Integer>> array = Tools.readFile(fileR);
        ArrayList<T> res = new ArrayList<>();
        if(str.equals("road")){
            for(int i = 0; i < array.size(); i++){
                res.add((T)new Road(array.get(i)));
            }

        }
        else if(str.equals("car")){
            for(int i = 0; i < array.size(); i++){
                res.add((T)new Car(array.get(i)));
            }

        }
        else if(str.equals("cross")){
            for(int i = 0; i < array.size(); i++){
                res.add((T)new Cross(array.get(i)));
            }

        }
       return res;
    }

  /*  public static void main(String[] args)throws IOException{
        ArrayList<Road> road = InitRun("F:\\Test\\road.txt","road");
        System.out.println(road);
        ArrayList<Car> car = InitRun("F:\\Test\\car.txt","car");
        System.out.println(car);
        ArrayList<Cross> cross = InitRun("F:\\Test\\cross.txt","cross");
        System.out.println(cross);
        EdgeWeightedDigraph dg = MyGraph.createGraph(road,cross);
       // DijkstraAllPairsSP spt = MyGraph.getShortestAll(dg);
        HashMap<Car,ArrayList<DirectedEdge>> map = MyGraph.getShortestCar(car,spt);
        for(Car each:map.keySet()){
            System.out.println(each.getId() + ":"+map.get(each));
        }
    }*/
}
