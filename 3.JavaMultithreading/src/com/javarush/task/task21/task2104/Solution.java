package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Solution n) {
//        if (this == n) return true;
//        if (n == null) return false;
//        if (!(n instanceof Solution)) return false;
//        return n.first.equals(first) && n.last.equals(last);
//    }

    public int hashCode() {
        return Objects.hash(first, last);
        //return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(new Solution("Donald", "Duck").equals(new Solution("Donald", "Duck")));
        System.out.println(Objects.equals(new Solution("Donald", "Duck"), new Solution("Donald", "Duck")));
        System.out.println(new Solution("Donald", "Duck").hashCode());
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;
        Solution s = (Solution) o;
        return Objects.equals(first, s.first) &&
                Objects.equals(last, s.last);
    }

}
