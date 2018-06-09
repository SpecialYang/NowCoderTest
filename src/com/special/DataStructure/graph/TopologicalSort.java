//package com.special.DataStructure.graph;
//
//import java.util.*;
//
///**
// * 拓扑排序--kaln算法
// * 拓扑排序为有向无环图中所有节点的线性排列，它很好保持了图中各节点的依赖关系
// * 若v有一条指向w的边，则v在线性排列的位置一定在w的之前。
// * 算法步骤（图的构建采用的是邻接表, 且构建图的过程中已经统计了各节点的入度值）：
// * 1. 遍历所有的节点的入度信息，把入度为0点的加入了队列中
// * 2. 判断当前队列是否为空，若不为空，则从队列中取出并删除一个节点
// * 然后再删除已该节点有狐尾的所有的边，同时更新该边的弧头对应节点的入度值，即减一
// * 若这个节点入度为0，则把它加入了队列
// * 3.重复2步骤，直到队列中没有入度为0点了
// * 4.判断输出的节点的数量是否等于总的节点数量。若不是，则说明该有向图有图
// * 不满足拓扑排序的先决条件！
// *
// * 该算法可以处理非数字作为顶点信息的情况，且可以处理多个Case
// * 测试数据：
// * 7 7
//B A
//A G
//B D
//D F
//C G
//C F
//D E
// * Create by Special on 2018/3/14 22:08
// */
//public class TopologicalSort {
//
//    static class Edge{
//        int vertex;
//        Edge next;
//
//        public Edge(int vertex){
//            this.vertex = vertex;
//        }
//    }
//
//    static class Vnode{
//        int vertex;
//        Edge firstEdge;
//
//        public Vnode(int value){
//            this.vertex = value;
//        }
//    }
//    static int n; //有向图的节点数量
//    static Vnode[] Vnodes; //邻接表的各表头信息，存放顶点编号和该点第一个边
//    static int[] indegrees; //顶点的入度
//    static char[] vertexValue; //为了处理非数字作为顶点值的情况，其值对应的索引极为顶点编号
//    static Queue<Integer> queue; //入度为0的队列
//    static List<Character> sortResult; //存放结果，保持顺序
//    static Map<Character, Integer> indices; //非数字作为顶点值对应的索引，利用哈希加快查询
//
//    public static List<Character> topologicalSort(){
//        for(int i = 0; i < n; i++){
//            if(indegrees[i] == 0){
//                queue.offer(i);
//            }
//        }
//        while(!queue.isEmpty()){
//            int vertex = queue.poll();
//            sortResult.add(vertexValue[vertex]);
//            for(Edge edge = Vnodes[vertex].firstEdge; edge != null; edge = edge.next){
//                indegrees[edge.vertex]--;
//                if(indegrees[edge.vertex] == 0){
//                    queue.offer(edge.vertex);
//                }
//            }
//        }
//        if(sortResult.size() < n){
//            System.out.println("Has a cycle!");
//        }
//        return sortResult;
//    }
//
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(input.hasNext()){
//            n = input.nextInt();
//            int m = input.nextInt();
//            queue = new LinkedList<>();
//            sortResult = new ArrayList<>();
//            indegrees = new int[n];
//            vertexValue = new char[n];
//            Vnodes = new Vnode[n];
//            indices = new HashMap<>();
//            int index = 0, srcIndex, drcIndex;
//            char src, drc;
//            while(m-- > 0) {
//                src = input.next().charAt(0);
//                if (indices.get(src) == null) {
//                    vertexValue[index] = src;
//                    indices.put(src, index);
//                    index++;
//                }
//                drc = input.next().charAt(0);
//                if (indices.get(drc) == null) {
//                    vertexValue[index] = drc;
//                    indices.put(drc, index);
//                    index++;
//                }
//                srcIndex = indices.get(src);
//                drcIndex = indices.get(drc);
//                if (Vnodes[srcIndex] == null) {
//                    Vnodes[srcIndex] = new Vnode(src);
//                }
//                if (Vnodes[drcIndex] == null) {
//                    Vnodes[drcIndex] = new Vnode(drc);
//                }
//                if(Vnodes[srcIndex].firstEdge == null){
//                    Vnodes[srcIndex].firstEdge = new Edge(drcIndex);
//                }else {
//                    Edge edge = Vnodes[srcIndex].firstEdge;
//                    while (edge.next != null) {
//                        edge = edge.next;
//                    }
//                    edge.next = new Edge(drcIndex);
//                }
//                indegrees[drcIndex]++;
//            }
//            topologicalSort();
//            for(char item : sortResult){
//                System.out.print(item + "---");
//            }
//            System.out.println();
//        }
//    }
//}
