import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;


class boothsalogorithm {
    static int pow (int n,int p){
        if(p==0){
        return 1;
        }
        if(p==1 ){
        return n;
        }
        return n*pow(n,p-1);
    }
    static int BinaryTodec(String s){
        int n=0;
        for (int i = 0; i < s.length(); i++) {
        n+= Integer.parseInt(Character.toString(s.charAt(i)))*pow(2,i);
        }
        return n;
    }
    static ArrayList<Integer> decToBinary(int n) {
        ArrayList<Integer> bin=new ArrayList<Integer>();
//        bin.add(0);
        int i = 0;
        while (n > 0) {
        bin.add(n % 2);
        n = n / 2;
        i++;
        }
        return bin;
    }
    static String addBinary(String a, String b)
        {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

        // Comput sum of last
        // digits and carry
        s += ((i >= 0)? a.charAt(i) - '0': 0);
        s += ((j >= 0)? b.charAt(j) - '0': 0);

        // If current digit sum is
        // 1 or 3, add 1 to result
        result = (char)(s % 2 + '0') + result;

        // Compute carry
        s /= 2;

        // Move to next digits
        i--; j--;
        }

        return result;
        }
    static String convert_arraylist_String(ArrayList a){
        String s="";
        for (int i = 0; i <a.size() ; i++) {
        s +=Integer.toString((Integer) a.get(i));
        }
        return s;
    }

    public static String convert_2scom(String s){
        String ns="";
        for (int i = 0; i < s.length(); i++) {
        if(s.charAt(i)=='0'){
        ns+="1";
        }
        else{
        ns+="0";
        }
        }
        String one="";
        for (int i = 0; i <s.length()-1 ; i++) {
        one += "0";
        }
        one+="1";
        return addBinary((ns),(one));
    }
    public static String[] ASR(String AC,String q,String q1){
        String q11=Character.toString(q.charAt(0));

        String nq="";
        for (int i = 1; i <q.length() ; i++) {
        nq+=Character.toString(q.charAt(i));
        }
        nq+=Character.toString(AC.charAt(0));
        q=nq;
        String nac="";
        for (int i = 1; i <AC.length() ; i++) {
        nac+=Character.toString(AC.charAt(i));
        }
        nac+=Character.toString(AC.charAt(AC.length()-1));
        AC=nac;
        String [] a={nac,nq,q11};
        return a;
    }
    public static void func_Both_positive(int n1,int n2){
//        converting numbers into array list
        ArrayList<Integer> M=decToBinary(n1);
        ArrayList<Integer> Q=decToBinary(n2);
//        adding zero because we have to take extra one bit
        M.add(0);
        Q.add(0);
//        converting Arraylist into String
        String M2=convert_arraylist_String(M);
        String Q2=convert_arraylist_String(Q);

//        equalizing the bit by comparing bit size
        if(M2.length()>Q2.length()){
        int a=M2.length()-Q2.length();
        for (int i = 0; i <a ; i++) {
        Q2=Q2+"0";
        }
        }
        else if(M2.length()<Q2.length()){
        int a=Q2.length()-M2.length();
        for (int i = 0; i <a ; i++) {
        M2=M2+"0";
        }
        }
        System.out.println();

        String AC="";
        for (int i = 0; i < M2.length(); i++) {
        AC+="0";
        }
        String q1="0";
        int count=M2.length();
        int registersize=count;
//        runinng cycle
        while (count>0){
//            checking q1 and q
        if((Q2.charAt(0)+q1).equals("10")){
        String nM=reverse(convert_2scom(reverse(M2)));
        AC=reverse(addBinary(reverse(AC),reverse(nM)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        else if((Q2.charAt(0)+q1).equals("01")){
        AC=reverse(addBinary(reverse(AC),reverse(M2)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        else{
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        System.out.print("AC ="+reverse(AC)+"    ");
        System.out.print("Q2 ="+reverse(Q2)+"    ");
        System.out.print("q1 ="+q1+"    ");
        System.out.println();
        count--;
        }
        System.out.println("Result "+reverse(AC)+reverse(Q2));
        String s1=reverse(AC)+reverse(Q2);
        System.out.println("Result in decimal "+BinaryTodec(reverse(s1)));
    }

    public static String reverse(String ac){
        String s="";
        for (int i = ac.length()-1; i >=0 ; i--) {
        s+=Character.toString(ac.charAt(i));
        }
        return s;
    }
    public static void func_one_negative(int n1,int n2){
//        converting numbers into array list
        ArrayList<Integer> M=decToBinary(n1);
        ArrayList<Integer> Q=decToBinary(n2);
//        adding zero because we have to take extra one bit
        M.add(0);
        M.add(0);
        Q.add(0);
        Q.add(0);
//        converting Arraylist into String
        String M2=convert_arraylist_String(M);
        String Q2=convert_arraylist_String(Q);

//        equalizing the bit by comparing bit size
        if(M2.length()>Q2.length()){
        int a=M2.length()-Q2.length();
        for (int i = 0; i <a ; i++) {
        Q2=Q2+"0";
        }
        }
        else if(M2.length()<Q2.length()){
        int a=Q2.length()-M2.length();
        for (int i = 0; i <a ; i++) {
        M2=M2+"0";
        }
        }
//        convert Multiplicant into 2's complicant
        String nM2=reverse(convert_2scom(reverse(M2)));
//        for printing in next line
        System.out.println();

        String AC="";
        for (int i = 0; i < M2.length(); i++) {
        AC+="0";
        }
        String q1="0";
        int count=M2.length();
        int registersize=count;
//        runinng cycle
        while (count>0){
//            checking q1 and q
        if((Q2.charAt(0)+q1).equals("10")){

        AC=reverse(addBinary(reverse(AC),reverse(M2)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        else if((Q2.charAt(0)+q1).equals("01")){
        AC=reverse(addBinary(reverse(AC),reverse(nM2)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        else{
        String[] aa=ASR(AC,Q2,q1);
        AC=aa[0];
        Q2=aa[1];
        q1=aa[2];
        }
        System.out.print("AC ="+reverse(AC)+"    ");
        System.out.print("Q2 ="+reverse(Q2)+"    ");
        System.out.print("q1 ="+q1+"    ");
        System.out.println();
        count--;
        }
        String s=reverse(convert_2scom(reverse(AC)+reverse(Q2)));
//        checking the number is not exceeding length of Ac + Q2 if it crossing than it will show 1 at the end which violet the rule that any number multiplied by 0 is equal to zero .so we are using substring to decrease it's size
        if(s.length()>= AC.length()+Q2.length()){
        s=s.substring(0,AC.length()+Q2.length());
        }
        System.out.println("Result "+'1'+reverse(s));
        System.out.println("Result in decimal -"+BinaryTodec(s));
    }
    public static void func_both_negative(int n1, int n2){
//        converting numbers into array list
        ArrayList<Integer> M=decToBinary(n1);
        ArrayList<Integer> Q=decToBinary(n2);
//        adding zero because we have to take extra one bit
        M.add(0);
        Q.add(0);
//        converting Arraylist into String
        String M2=convert_arraylist_String(M);
        String Q2=convert_arraylist_String(Q);
//        equalizing the bit by comparing bit size
        if(M2.length()>Q2.length()){
        int a=M2.length()-Q2.length();
        for (int i = 0; i <a ; i++) {
        Q2=Q2+"0";
        }
        }
        else if(M2.length()<Q2.length()){
        int a=Q2.length()-M2.length();
        for (int i = 0; i <a ; i++) {
        M2=M2+"0";
        }
        }
//        convert Multiplicant into 2's complicant
        String nM2=reverse(convert_2scom(reverse(M2)));
//        convert Q into 2's complicant
        String nQ2=reverse(convert_2scom(reverse(Q2)));
        System.out.println();

        String AC="";
        for (int i = 0; i < M2.length(); i++) {
        AC+="0";
        }
        String q1="0";
        int count=M2.length();
        int registersize=count;
//        runinng cycle
        while (count>0){
//            checking q1 and q
        if((nQ2.charAt(0)+q1).equals("10")){

        AC=reverse(addBinary(reverse(AC),reverse(M2)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,nQ2,q1);
        AC=aa[0];
        nQ2=aa[1];
        q1=aa[2];
        }
        else if((nQ2.charAt(0)+q1).equals("01")){
        AC=reverse(addBinary(reverse(AC),reverse(nM2)));
        if(AC.length()>registersize){
        AC=AC.substring(0,registersize);
        }
        String[] aa=ASR(AC,nQ2,q1);
        AC=aa[0];
        nQ2=aa[1];
        q1=aa[2];
        }
        else{
        String[] aa=ASR(AC,nQ2,q1);
        AC=aa[0];
        nQ2=aa[1];
        q1=aa[2];
        }
        System.out.print("AC ="+reverse(AC)+"    ");
        System.out.print("Q2 ="+reverse(nQ2)+"    ");
        System.out.print("q1 ="+q1+"    ");
        System.out.println();
        count--;
        }
        String s11=reverse(AC)+reverse(nQ2);
        System.out.println("Result "+reverse(AC)+reverse(nQ2));
        System.out.println("Result in decimal "+ BinaryTodec(reverse(s11)));
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n1;
        int n2;
        int q_1=0;
        System.out.println("Enter 1st number");//multiplicant
        n1=s.nextInt();
        System.out.println("Enter 2nd number");// multiplier
        n2=s.nextInt();
        if(n1>=0 && n2>=0){
        func_Both_positive(n1,n2);
        }
        if((n1<0 && n2>0) || (n1>0 && n2<0) || (n1==0 && n2<0) || (n1<0 && n2==0)){
        func_one_negative(Math.abs(n1),Math.abs(n2));
        }
        if(n1<0 && n2<0){
        func_both_negative(Math.abs(n1),Math.abs(n2));
        }
    }
}

