class longestPalindrome {
    public static int longestPalindrom(String[] words) {
        StringBuilder str= new StringBuilder();
        for(int i=0;i<words.length;i++){
            if(helper(words, words[i],i)){
                str.insert(0,words[i]);
                str.append(new StringBuilder(words[i]).reverse());
            }else{
                String s = words[i];
                if(s.charAt(0)==s.charAt(1)&& str.isEmpty()) 
                str.insert(0,s);
                else if(s.charAt(0)==s.charAt(1) && str.length()>2)
                str.insert(str.length()/2,s);
            }
        }
        System.out.println(str);
        return str.length();
    }
    static boolean helper(String arr[],String str,int i){
        if(i==arr.length) return false;
        StringBuilder s = new StringBuilder(str);
        s.reverse();
        String rev = s.toString();
        System.out.println(rev);
        for(int j=i+1;j<arr.length-1;j++){
            String newStr = arr[j];
            if(newStr.equals(rev)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"lc","ll","gg"};
        int a=longestPalindrom(words);
        System.out.println(a);
    }
}