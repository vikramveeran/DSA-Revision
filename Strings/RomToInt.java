import java.util.HashMap;

class RomToInt{
    public static void main(String[] args){
           String s = "C";
           System.out.println(romToInt(s));
    }
    static int romToInt(String s){
        HashMap<Character,Integer>map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int resultInt = map.get(s.charAt(0));
       for(int i=1; i<s.length(); i++){
         if(map.containsKey(s.charAt(i))){
            if(map.get(s.charAt(i)) > map.get(s.charAt(i-1))){
                resultInt -= map.get(s.charAt(i-1));
              resultInt += map.get(s.charAt(i)) - map.get(s.charAt(i-1));
         }
         else{
             resultInt += map.get(s.charAt(i));
          }
         }       
       }
       return resultInt;
    }
}

