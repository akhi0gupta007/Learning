package com.learn;

public class StringPlay {
	
static long repeatedString(String s, long n) {        
        int j = 0;
        StringBuilder builder = new StringBuilder();
        while(j < n && builder.length() <= n ){
            builder.append(s);
            j++;
        }
        String calc = builder.substring(0,(int)n);        
        
        char arr[] =  calc.toCharArray();
        long count = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == 'a'){
                count++;
            }
        }
        return  count;
    }

	public static void main(String[] args) {
		System.out.println(repeatedString("aba", 10));
		System.out.println(repeatedString("a", 1000000000000l));
	}

}
