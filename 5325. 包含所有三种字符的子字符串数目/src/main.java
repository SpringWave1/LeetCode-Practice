public class main {
    public static void main(String args[]){
        System.out.print(new Solution5325().numberOfSubstrings("abdabc"));
    }
}

class Solution5325 {
    public int numberOfSubstrings(String s) {
        long len = s.length();
        long all_sub = len*(len+1)/2;

        // have no a
        String[] no_a_sub = s.split("a");
        long no_a = compute(no_a_sub);
        // have no b
        String[] no_b_sub = s.split("b");
        long no_b = compute(no_b_sub);
        // have no c
        String[] no_c_sub = s.split("c");
        long no_c = compute(no_c_sub);

        // have no a and no b
        String replace_a = s.replace('a', ' ');
        String[] no_ab_sub = replace_a.replace('b', ' ').split( " ");
        long no_ab = compute(no_ab_sub);
        // have no a and no c
        String[] no_ac_sub = replace_a.replace('c', ' ').split( " ");
        long no_ac = compute(no_ac_sub);
        // have no b and no c
        String replace_b = s.replace('b', ' ');
        String[] no_bc_sub = replace_b.replace('c', ' ').split( " ");
        long no_bc = compute(no_bc_sub);

        return (int) (all_sub-no_a-no_b-no_c+no_ab+no_bc+no_ac);
    }

    public int compute(String[] no_X_sub){
        long sum = 0;
        long len;
        for (String sub : no_X_sub){
            if (sub.equals("")) continue;
            len = sub.length();
            sum += len*(len+1)/2;
        }
        return (int) sum;
    }
}