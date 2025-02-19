package org.example;

public class BonusTask {

    public static String compressString(String string){
        // Checking if string is valid
        if(string == null || string.isEmpty()){
            return "";
        }

        // For counting letters
        int counter = 1;
        // StringBuilder for build a string, because adding strings create new string every time adding and it is slower
        StringBuilder compressedString = new StringBuilder();

        // For loop starts from 1 for comparing previous letter without getting out of bounds exception
        for(int i = 1; i < string.length(); i++){
            // Comparing chars
            if(string.charAt(i) == string.charAt(i - 1)){
                counter++;
            // If letters doesn't match append what we have to string builder and reset counter
            } else {
                compressedString.append(string.charAt(i - 1)).append(counter);
                counter = 1;
            }
        }
        // After loop we add what is left and return compressed string
        return compressedString.append(string.charAt(string.length() - 1)).append(counter).toString();

    }

    public static String decompressString(String string){
        // Checking if string is valid
        if(string == null || string.isEmpty()){
            return "";
        }
        // StringBuilder for build a string, because adding strings create new string every time adding and it is slower
        StringBuilder decompressedString = new StringBuilder();

        for(int i = 0; i < string.length(); i++){
            // Since we don't know how many digits is near each letter we need to extract it and store it here
            StringBuilder countString = new StringBuilder();

            // Variable to know at what index digits start
            int j = i + 1;

            // Iterating until string ends or we reach other letter and appending to count string
            while (j < string.length() && Character.isDigit(string.charAt(j))){
                countString.append(string.charAt(j));
                j++;
            }

            //Converting to int
            int howMany = Integer.parseInt(countString.toString());

            //Repeating appending same letter by extracted number
            decompressedString.append(String.valueOf(string.charAt(i)).repeat(howMany));

            //Setting i variable to start next loop skipping digits
            i = j - 1;
        }
        return decompressedString.toString();
    }

}
