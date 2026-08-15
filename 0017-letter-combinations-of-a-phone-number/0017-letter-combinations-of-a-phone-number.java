class Solution {
    public List<String> letterCombinations(String digits) {
    List <String> result=new ArrayList<>();
    if(digits.length()==0){
        return result;
    } 
String[] map = {
    "", "", "abc", "def", "ghi",
    "jkl", "mno", "pqrs", "tuv", "wxyz"
};    result.add("");
    for(int i=0;i<digits.length();i++){
        String letter=map[digits.charAt(i)-'0'];
        List<String> next=new ArrayList<>();
        for(int j=0;j<result.size();j++){
            String combination=result.get(j);
            for(char ch:letter.toCharArray()){
                next.add(combination+ch);
            }
        }
    result=next;
    } 
    return result; 
    }
}