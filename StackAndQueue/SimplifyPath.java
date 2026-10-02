import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path  = "/a/./b/../c";
        System.out.println(simplifyPath(path));
    }
    static String simplifyPath(String path){
         Stack<String>stack = new Stack<>();
         String[] paths = path.split("/");
         for(String c : paths){
             if(c.equals("..")){
                 if(!stack.isEmpty()){
                     stack.pop();
                 }
                }
                 else if(!c.equals(".") && !c.equals("")){
                      stack.push(c);
                 }
             
         }
         return "/"+String.join("/",stack);
    }
}

/*🧠 Pattern: Split → Ignore → Remove → Add */