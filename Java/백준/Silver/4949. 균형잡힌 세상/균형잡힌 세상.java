import java.util.*;

class Main{
    public static void main(String[] args){
        
        Scanner scan=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        while(true){
            String in=scan.nextLine();
            if(in.equals(".")) break;
            
            boolean end=false;
            
            String[] temp=in.split("");
            
            Stack<String> stack=new Stack<>();
            
            for(String s:temp){
                if(s.equals("("))stack.add(s);
                else if(s.equals(")")){
                    
                    if(stack.isEmpty()){
                        sb.append("no").append("\n");
                        end=true;
                        break;
                    }else if(stack.peek().equals("(")) {
                        stack.pop();
                    }
                    else{
                        sb.append("no").append("\n");
                        end=true;
                        break;
                    }
                    
                }else if(s.equals("[")) {
                    stack.add("[");
                }
                else if(s.equals("]")){
                    if(stack.isEmpty()){
                        sb.append("no").append("\n");
                        end=true;
                        break;
                    }else if(stack.peek().equals("[")) stack.pop();
                    else{
                        sb.append("no").append("\n");
                        end=true;
                        break;
                    }
                }
                

            }
                if(!end) {
                    if(stack.size()==0) sb.append("yes").append("\n");       
                    else sb.append("no").append("\n");
                }
        }
        
        System.out.println(sb);
        
    }
}