package BitManupulation;

public class ConvertToDecimal {
    public static void main(String[] args) {
        String binary = "1101";
        System.out.println(convertToDecimal(binary));
    }
    static int convertToDecimal(String binary){
        int p2 = 1;
        int num  =0;
        for(int i=binary.length()-1; i>=0;i--){
             if(binary.charAt(i) == '1'){
                num = num+p2;
             }
              p2 = p2*2;
           }
        return num;
    }
}
