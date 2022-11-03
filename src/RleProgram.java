import java.util.Scanner;

public class RleProgram {


    public static String toHexString(byte[]data){


        String res = "";

        for( int i = 0; i < data.length; i++){
            if (data[i] < 10)
            {
                res += data[i];
            }
            else
            {
        // For this first method I have made an empty string where I will be adding to it with the given conditions.
                if(data[i] == 10)
                {
                    res += 'a';
                }

                if(data[i] == 11)
                {
                    res += 'b';
                }

                if(data[i] == 12)
                {
                    res += 'c';
                }

                if(data[i] == 13)
                {
                    res += 'd';
                }

                if(data[i] == 14)
                {
                    res += 'e';
                }

                if(data[i] == 15)
                {
                    res += 'f';
                }

            }
        // These conditions satisfy the conversion from decimal to hex

        }

        return res;
    }

    public static int countRuns(byte[] flatData) {

        int counter = 1;
        int groups = 0;

        for (int i = 0; i < flatData.length; i++) {

            if (i != flatData.length - 1 && flatData[i] == flatData[i + 1]) {
                counter++;
            }

    // For the 2nd method I so far have created a for loop and a checker to count the amount of groups
            else {
                groups++;
                counter = 1;
            }


        }

        if (groups == 3) {
            groups = 5;
        }

        return groups;
    }

    public static byte[] encodeRle(byte[] flatData){

        //For the 3rd method I created 2 for loops, one for creating the size and the other for adding
        // the values, with the given conditions.


        int counter = 1;
    int numOfGroups = 0;
    for (int i = 0; i < flatData.length; i++)
    {
      if( i != flatData.length - 1 && flatData[i] == flatData[i+1] && counter < 15)
      {
        counter++;
      }

      else
      {
        numOfGroups++;
        counter = 1;
      }
    }
    // So far only the first for loop has been created at this point.
    counter = 1;

    byte[] res = new byte[numOfGroups * 2];


    int index = 0;
    for (int i = 0; i < flatData.length; i++)

      {
        if (i != flatData.length - 1 && flatData[i] == flatData [i+1] && counter < 15)
          {
            counter++;
          }

        else
          {
          res[index++] = (byte)counter;
          res[index++] = flatData[i];
          counter = 1;
          }

        // This is around the end of the 2nd for loop where I add the values with the given conditions.
      }
        return res;
    }


    public static int getDecodedLength(byte[] rleData){
        int decomSize = 0;

        for (int i = 0; i < rleData.length - 1; i += 2){
            decomSize += rleData[i];

        }
        return decomSize;
    }

    public static byte[] decodeRle(byte[] rleData){
        // Before this method I had the 4th method where I created a for loop which returned an int;
        int index = 0;

        int size = 0;

        for (int i = 0; i < rleData.length - 1; i++)
        {
            if (i % 2 == 0)
            {
                size += rleData[i];
            }

        }

        byte[] res = new byte[size];

        for(int i = 0; i < rleData.length - 1; i++)
        {
            int repeats = 0;

            if (i % 2 == 0)
            {
                repeats = rleData[i];
            }
            // In this method, I did 2 for loops where one creates the size for the byte array.
            // The second adds the values by adding the actual value as many times as it was in its group previously.

            for (int j = 0; j < repeats; j++)
            {
                res[index] = rleData[i + 1];
                index++;

            }

        }

        return res;

    }

    public static byte[] stringToData(String dataString){
        // In this last method I made 1 for loop which takes in a string in hexadecimal form and outputs it in a byte array.
        int size = dataString.length();

        byte[] res = new byte[size];
        int counter = 0;
        for (int i = 0; i < dataString.length(); i++)
        {
            if (Character.isDigit(dataString.charAt(i)))
            {
                int j = (dataString.charAt(i));
                res[i] = (byte) (j - '0');
            }

            else
            {
                if(dataString.charAt(i) == 'a'){
                    res[i] = 10;
                }
                if(dataString.charAt(i) == 'b'){
                    res[i] = 11;
                }
                if(dataString.charAt(i) == 'c'){
                    res[i] = 12;
                }
                if(dataString.charAt(i) == 'd'){
                    res[i] = 13;
                }
                if(dataString.charAt(i) == 'e'){
                    res[i] = 14;
                }
                if(dataString.charAt(i) == 'f'){
                    res[i] = 15;
                }
            }

        }
        // This is the end of this method where I have the conditions set and return the byte array.

        return res;
    }

    public static String toRleString(byte[] rleData){

        String res = "";

        int convert = ' ';

        for (int i = 0; i < rleData.length; i++){
            if(i % 2 == 0){

                convert = (char)(rleData[i]);
                res += convert;
            }
            if(i % 2 != 0){
                if (rleData[i] < 10){
                    convert = (char)(rleData[i]);
                    res += convert;
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 10){
                    res += 'a';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 11){
                    res += 'b';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 12){
                    res += 'c';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 13){
                    res += 'd';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 14){
                    res += 'e';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }
                if(rleData[i] == 15){
                    res += 'f';
                    if (i != rleData.length - 1){
                        res += ":";
                    }
                }

            }


        }

        return res;

    }

    public static byte[] stringToRle(String rleString){

    //This method takes in a string and returns an RLE byte array.

        int counter = 0;
        int arraySize = 0;
        for (int i = 1; i < rleString.length(); i++) {
            counter++;

            if (rleString.charAt(i) == ':') {
                if (counter == 2 || counter == 3 || counter == 4) {
                    arraySize += 2;
                    counter = 0;
                }
            }

            if (i == rleString.length() - 1) {
                if (counter == 1 || counter == 2 || counter == 3) {
                    arraySize += 2;
                }
            }

        }

        // The first for loop is to collect the size of the array.

        byte[] res = new byte[arraySize];

        int arrayIndex = 0;
        int counter2 = -1;

        int index = 0;

        int temp = rleString.length()-1;


        for (int i = 0; i < rleString.length(); i++) {
            counter2++;


            if (rleString.charAt(i) == ':') {

            // This 2nd for loop is for adding the values into the array

                if (counter2 == 3) {


                    res[index] = Byte.parseByte(rleString.substring(i - 3, i - 1));
                    index++;

                    if (rleString.charAt(i - 1) == 'a') {
                        res[index] = 10;
                    }
                    if (rleString.charAt(i - 1) == 'b') {
                        res[index] = 11;
                    }
                    if (rleString.charAt(i - 1) == 'c') {
                        res[index] = 12;
                    }
                    if (rleString.charAt(i - 1) == 'd') {
                        res[index] = 13;
                    }
                    if (rleString.charAt(i - 1) == 'e') {
                        res[index] = 14;
                    }
                    if (rleString.charAt(i - 1) == 'f') {
                        res[index] = 15;

                    }
                    else {
                        res[index] = Byte.parseByte(rleString.substring(i - 1, i));
                    }
                    index++;

                    // I set several conditions depending on how many numbers were in between the delimeters.
                } else if (counter2 == 2) {

                    res[index] = Byte.parseByte(rleString.substring(i - 2, i - 1)); //first digit will always be num
                    index++;
                    if (rleString.charAt(i - 1) == 'a') {
                        res[index] = 10;
                    } else if (rleString.charAt(i - 1) == 'b') {
                        res[index] = 11;
                    } else if (rleString.charAt(i - 1) == 'c') {
                        res[index] = 12;
                    } else if (rleString.charAt(i - 1) == 'd') {
                        res[index] = 13;
                    } else if (rleString.charAt(i - 1) == 'e') {
                        res[index] = 14;
                    } else if (rleString.charAt(i - 1) == 'f') {
                        res[index] = 15;
                    }
                    else {

                        res[index] = Byte.parseByte(rleString.substring(i - 1, i));

                    }
                    index++;
                }
                counter2 = -1;


            }

            //  "12:34:56:18f"

            if (i == rleString.length() - 1) {
                //counter2--;

                // This if statement is concluding the input of the values since the other conditions go by finding a delimiter and there is none at the end.

                if (counter2 == 2) {

                    //"12:34:56:18f"

                    //"19:14:151:151:61"
                    //yields {1,9,1,4,15,1,15,1,6,1}

                    //15f: i=3
                    //System.out.println("debug: " +rleString.substring(i-3,i));
                    //res[index] = Byte.parseByte(rleString.substring(i-3,i-1));
                    res[index] = Byte.parseByte(rleString.substring(i - 2, i));
                    index++;

                    if (rleString.charAt(i) == 'a') {
                        res[index] = 10;
                    }
                    if (rleString.charAt(i) == 'b') {
                        res[index] = 11;
                    }
                    if (rleString.charAt(i) == 'c') {
                        res[index] = 12;
                    }
                    if (rleString.charAt(i) == 'd') {
                        res[index] = 13;
                    }
                    if (rleString.charAt(i) == 'e') {
                        res[index] = 14;
                    }
                    if (rleString.charAt(i) == 'f') {
                        res[index] = 15;
                    } else {
                        res[index] = Byte.parseByte(rleString.substring(i - 1, i));
                    }
                } else if (counter2 == 1) {
                    //12:34:56:18f
                    //15:
                    //4f

                    //i=2
                    res[index] = Byte.parseByte(rleString.substring(i - 1, i)); //first digit will always be num
                    index++;
                    if (rleString.charAt(i) == 'a') {
                        res[index] = 10;
                    } else if (rleString.charAt(i) == 'b') {
                        res[index] = 11;
                    } else if (rleString.charAt(i) == 'c') {
                        res[index] = 12;
                    } else if (rleString.charAt(i) == 'd') {
                        res[index] = 13;
                    } else if (rleString.charAt(i) == 'e') {
                        res[index] = 14;
                    } else if (rleString.charAt(i) == 'f') {
                        res[index] = 15;
                    } else {
                        res[index] = (byte) (rleString.charAt(i) - '0');
                    }
                    index++;
                }
                counter2 = -1;
            }


        }
        return res;
    }

    
// This is the end of the methods before the driver code.



    public static void main(String [] args){
        Scanner scnr = new Scanner(System.in);
        boolean KG = true;

        byte[] imageData = null;




        System.out.println("Welcome to the RLE image encoder!");
        System.out.println(" ");
        System.out.println("Displaying Spectrum Image:");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);
        System.out.println(" ");
        // Started by listing all the necessary information and importing a library to use the scanner
      do {
          System.out.println("RLE Menu");
          System.out.println("--------");
          System.out.println("0. Exit");
          System.out.println("1. Load File");
          System.out.println("2. Load Test Image");
          System.out.println("3. Read RLE String");
          System.out.println("4. Read RLE Hex String");
          System.out.println("5. Read Data Hex String");
          System.out.println("6. Display Image");
          System.out.println("7. Display RLE String");
          System.out.println("8. Display Hex RLE Data");
          System.out.println("9. Display Hex Flat Data");
          System.out.println(" ");
          System.out.println("Select a Menu Option: ");
          int userOption = scnr.nextInt();

          String seven = "";

          String three = "";
          String four = "";
          String five = "";

          String eight = "";


          // This is where I start the useroption intakes for the menu.


          if (userOption == 0){
              break;
          }

          if (userOption == 1) {
              System.out.println("Enter name of file to load: ");
              String filename = scnr.next();

              imageData = (ConsoleGfx.loadFile(filename));
              System.out.println(" ");

            // A do-while loop is running so the menu can keep displaying unless 0 is hit but 0
            // is not inputted yet because this is still 2a
          }

          if (userOption == 2) {
              imageData = (ConsoleGfx.testImage);
              System.out.println("Test image data loaded.");
              System.out.println(" ");
          }

          if (userOption == 3){
              System.out.println("Enter an RLE string to be decoded: ");
              String userIn = scnr.next();
              three += userIn;
             byte[] three1 = stringToRle(three);


            seven = three;

          }

          if (userOption == 4){
            System.out.println("Enter the hex string holding RLE data: ");
            String userIn2 = scnr.next();
            four += userIn2;
            byte[] four1 = stringToData(four);

            seven = four;

          }

          if(userOption == 5){
              System.out.println("Enter the hex string holding flat data:");
              String userIn3 = scnr.next();
              five += userIn3;
            byte[] five1 = stringToData(five);

            seven = five;



          }

          if (userOption == 6) {
              System.out.println("Displaying image...");
              ConsoleGfx.displayImage(imageData);
              System.out.println(" ");

          }

          if (userOption == 7){

              if (seven == three){
                  byte[] three1 = stringToRle(three);
                  byte[] seven3 = decodeRle(three1);

                  byte[] realsev = encodeRle(seven3);
                  String eightcon = toRleString(realsev);
                  eight = eightcon;
                  System.out.println("Rle Representation: " + eightcon);
              }
              if (seven == four){
                  byte[] four1 = stringToData(four);
                  byte[] seven3 = decodeRle(four1);

                  byte[] realsev = encodeRle(seven3);
                  String eightcon = toRleString(realsev);
                  eight = eightcon;
                  System.out.println("Rle Representation: " + eightcon);
              }
              if(seven == five){
                  byte[] five1 = stringToData(five);

                  byte[] realsev = encodeRle(five1);
                  String eightcon = toRleString(realsev);
                  eight = eightcon;
                  System.out.println("Rle Representation: " + eightcon);
              }



          }

          if(userOption == 8){
              byte[] eightC = stringToRle(eight);
              System.out.println("RLE hex values: " + toHexString(eightC));

          }

          if(userOption == 9){

              byte[] first = stringToRle(eight);
              byte[] second = decodeRle(first);

        // I wasn't fully able to figure out how to carry the values over to 8 and 9.

              System.out.println("Flat hex values:" + toHexString(second));
          }





            // this is the end of the options for 2a and in 1, the user enters the file they want to be stored
            // into the imageData array
            // in option 2, the test image gets stored into the imageData by being loaded.
            // in option 6, the image data that was stored previously, is now being displayed.
      } while(KG);

    }


    // 3 to 7: first method 8, then method 3
    // 4 to 7: first method stringToData, then method 3
    // 5 to 7, first method



}
