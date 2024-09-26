import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int cnt = scan.nextInt();
        String[] input = new String[cnt];
        scan.nextLine();
        for (int i = 0; i < cnt; i++) {
            input[i] = scan.nextLine();
        }
        scan.close();

        HashSet<String> hashSet=new HashSet<>(List.of(input));

        input=hashSet.toArray(new String[0]);

        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else{
                    return -1;
                }
            }
        });

        StringBuilder sb=new StringBuilder();

        for(String s:input){
            sb.append(s).append("\n");
        }

        System.out.println(sb);

    }
}