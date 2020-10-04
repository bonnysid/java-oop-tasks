package Tasks_3;

import Tasks_1.Comment;
import Tasks_2.SubComment;

public class Main {
    public static void main(String[] args) {
        Post test = new Post("Transistor history", "aajbjapnfponjerpjnopen", 10);
        test.addTags("History", "IT", "electronics");
        test.addComments("Держите ссылку на то как работают светодиоды из карбида кремния ввв.свет.ру", 1)
                .addComments("thanks", 2)
                .addComments()
                .addComments("fsd", 1);
        System.out.println(test);
    }
            }
