package other;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dominick Martelly on 12/19/2016 at 12:02 PM.
 *
 * Finds all the images in the file system
 *
 * Example
 * root
 *  f1
 *   txt1.txt
 *  f2
 *   txt2.txt
 *   pic1.jpg
 *   f21
 *    word1.doc
 *   f22
 *    pic2.jpg
 *    pic3.jpg
 *  f3
 *   picture.jpg
 *
 * @author Dominick Martelly
 */
public class FileSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\n");
        Stack<String> myStack = new Stack<>();
        while (in.hasNext()) {
            StringBuilder currString = new StringBuilder(in.next());
            //Get spaces count
            int spacesCount = countBeginningSpaces(currString.toString());
            //Remove spaces
            currString = new StringBuilder(removeBeginningSpaces(currString.toString()));
            //Set the stack to the right position
            while (spacesCount < myStack.size()) {
                myStack.pop();
            }
            //If the next line is a folder
            if (isFolder(currString.toString())) {
                myStack.push(currString + "/");
                //System.out.println(Arrays.toString(myStack.toArray()));
            //Check if next line is a picture
            } else if (isImage(currString.toString())) {
                Stack<?> copyStack = (Stack<?>) myStack.clone();
                while (!copyStack.isEmpty()) {
                    currString.insert(0, copyStack.pop());
                }
                System.out.println(currString);
                //System.out.println("char length of " + currString.length());
                System.out.println();
            }
        }
        in.close();
    }

    private static int countBeginningSpaces(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                return i;
            }
        }
        //Should never happen
        System.out.println("Error!");
        return -1;
    }

    private static boolean isImage(String s) {
        return s.substring(s.length() - 4).compareTo(".jpg") == 0;
    }

    private static boolean isFolder(String s) {
        if (s.length() < 5)
            return true;
        else if (s.charAt(s.length() - 4) != '.')
            return true;
        return false;
    }

    private static String removeBeginningSpaces(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                return s.substring(i);
        }
        return s;
    }
}
