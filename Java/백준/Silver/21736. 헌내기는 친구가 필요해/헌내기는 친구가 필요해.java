    import java.util.*;

    public class Main {

        private static boolean[][] visited;
        private static String[][] graph;

        private static int[] dx=new int[]{1,0,-1,0};
        private static int[] dy=new int[]{0,1,0,-1};

        private static int M;
        private static int N;

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            N=scan.nextInt();
            M=scan.nextInt();

            scan.nextLine();

            graph=new String[N][M];
            visited=new boolean[N][M];

            for(int i=0;i<N;i++){
                graph[i]=scan.nextLine().split("");
            }

            int x=0,y=0;

            loop1:
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(graph[i][j].equals("I")){
                        x=i;
                        y=j;
                        break loop1;
                    }
                }
            }

            int counter=bfs(x,y);

            System.out.println(counter>0?counter:"TT");

        }


        private static int bfs(int x,int y){
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{x,y});
            visited[x][y]=true;

            int counter=0;

            while (!queue.isEmpty()){
                int[] vector=queue.poll();

                for(int i=0;i<4;i++){
                    int DX=vector[0]+dx[i];
                    int DY=vector[1]+dy[i];
                    if(DX>=0&&DX<N&&DY>=0&&DY<M&&(graph[DX][DY].equals("O")||graph[DX][DY].equals("P"))&&!visited[DX][DY]){
                        queue.add(new int[]{DX,DY});
                        visited[DX][DY]=true;
                        if(graph[DX][DY].equals("P")) counter++;
                    }
                }
            }

            return counter;

        }
    }