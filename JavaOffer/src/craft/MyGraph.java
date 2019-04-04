package craft;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class MyGraph {
    public static EdgeWeightedDigraph createGraph(ArrayList<Road> road, ArrayList<Cross> cross){
        //创建一个图
        EdgeWeightedDigraph dg = new EdgeWeightedDigraph(cross.size()+1);
        //添加有向边
        for(int i = 0; i < road.size(); i++){
            dg.addEdge(new DirectedEdge(road.get(i).getStartID(),road.get(i).getEndID(),road.get(i).getWeight()));
            if(road.get(i).getIsDual()==1){
                dg.addEdge(new DirectedEdge(road.get(i).getEndID(),road.get(i).getStartID(),0));
            }
        }
        //输出现有的图
        System.out.println(dg);
        return dg;
    }
  /*  //任意两个节点的最短路径
    public static DijkstraAllPairsSP getShortestAll(EdgeWeightedDigraph dg){
        DijkstraAllPairsSP spt = new DijkstraAllPairsSP(dg);
        return spt;
    }*/

    //获取每个车辆的最短路径
    public static HashMap<Car,ArrayList<DirectedEdge>> getShortestCar(ArrayList<Car> car,EdgeWeightedDigraph dg){
        //求出每个车辆的最短路径

        //根据出发时间为车排序
        car.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.time-o2.time;
            }
        });

        /**
         * 为每个车选择最短路径
         * - 为每一条边设置权重
         *   - 第一辆车边的权重：road.length/Math.max(carSpeed,roadSpeed)
         *   - 第二辆车边的权重: road.length/Math.max(carSpeed,roadSpeed)+每条边的负载(现在每条路上有几辆车)
         * - 选择某两点间的最短路径
         * - 将路径加入map中
         */
        HashMap<Car,ArrayList<DirectedEdge>> map = new HashMap<>();
        for(int i = 0; i < car.size(); i++){
            //有序遍历所有车
            //为每一辆车设置权重
            setWeight(car,i,dg);
            /*ArrayList<DirectedEdge> pathList = new ArrayList<>();
            for (DirectedEdge e : spt.path(each.getStartCross(),each.getEndCross()))
            {
              pathList.add(e);
            }
            map.put(each,new ArrayList<>(pathList));*/
        }
        return map;
    }

    //设置每条路的权重
    public static void setWeight(ArrayList<Car> car, int cur,EdgeWeightedDigraph dg){
        //遍历之前的车走到哪里了，计算现在每条路的负载
        int curTime = car.get(cur).getTime();
        for(int i = 0; i < cur; i++){
           // int timeDiff = curTime - car.get(i).getTime();
           //   float roadLoad = (float)cur/
        }
    }



}
