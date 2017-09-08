package homework170823;

class Main {
    /*
    August 23, 2017
написать программу, подсчитывающую частоту слов в тексте.

input:
one one two two three

output:
one 2
two 2
three 1
     */
    public static void main(String[] args) {
        StreamCounter.count("one", "two", "two", "three");

        ForEachCounter.count("one", "two", "two", "three");
    }

}

