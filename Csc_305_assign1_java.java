/*
 * Jacob Smith
 * V00700979
 * CSC 305
 * Assignment 1
 */
package csc_305_assign1_java;

import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class Csc_305_assign1_java {

    // Gets and returns bounded integer input from user input
    public static int user_input_int(int low_bound, int high_bound){
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter a number between " + low_bound + " and " + high_bound + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input!");
                sc.next(); // clear stream
            }
            number = sc.nextInt();
        } while ( number < low_bound && number > high_bound);
        return number;
    }
    
    // Gets and returns any integer from user input
    public static int user_input_int(){
        Scanner sc = new Scanner(System.in);
        int number;
        
        
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input!");
            sc.next(); // clear stream
        }
        number = sc.nextInt();
        
        return number;
    }
    
    // Gets and returns any double from user input
    public static double user_input_double(){
        Scanner sc = new Scanner(System.in);
        double number;
        
        
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a number!");
            sc.next(); // clear stream
        }
        number = sc.nextDouble();
        
        return number;
    }
    
    // Fills the passed in matrix with user input
    public static void fillMatrix (Matrix mx){
        
        int i,j;
        for( i=0; i< mx.grid.length; i++){
            for( j=0; j< mx.grid[0].length; j++){
                System.out.println("Enter a number for element [" + i + "][" + j + "]: ");
                mx.grid[i][j] = user_input_int();
            }
        }
    }
    
    // Prints the main menu
    public static void mainMenu (){
        System.out.println("1: transpose a matrix");
        System.out.println("2: equality check 2 matrices");
        System.out.println("3: multiply 2 matrices");
        System.out.println("4: inverse a matrix");
        System.out.println("5: dot product 2 matrices");
        System.out.println("6: cross product 2 matrices");
        System.out.println("7: x-axis, rotate 3d point");
        System.out.println("8: y-axis, rotate 3d point");
        System.out.println("9: z-axis, rotate 3d point");
        System.out.println("10: translate 3d point");
        System.out.println("11: scale of 2 3d point");
        System.out.println("0: exit");
    }
    
    // Transpose matrix option
    public static void optTranspose(){
        // get desired row and column size
        int urows, ucolumns;
        System.out.println("Number of rows: ");
        urows = user_input_int(1,100);
        System.out.println("Number of columns: ");
        ucolumns = user_input_int(1,100);
        
        // create, fill, transpose, and print matrix
        Matrix mx = new Matrix(urows,ucolumns);
        fillMatrix(mx);
        mx.transposeMatrix();
        System.out.println("\nResult: \n" + mx.getString());
    }
    
    // Matrix equality option
    public static void optEquality(){
        // get desired row and column size for matrix 1
        int urows, ucolumns;
        System.out.println("Number of rows for m1: ");
        urows = user_input_int(1,100);
        System.out.println("Number of columns for m1: ");
        ucolumns = user_input_int(1,100);
        
        // fill matrix 1
        Matrix mx = new Matrix(urows,ucolumns);
        fillMatrix(mx);
        
        // get desired row and column size for matrix 2
        System.out.println("Number of rows for m2: ");
        urows = user_input_int(1,100);
        System.out.println("Number of columns for m2: ");
        ucolumns = user_input_int(1,100);
        
        // fill matrix 2
        Matrix mx2 = new Matrix(urows,ucolumns);
        fillMatrix(mx2);
        
        // compare matrices and print result
         if (mx.compareMatrix(mx2)){
            System.out.println("Those matrices are equal");
         } else {
            System.out.println("Those matrices are not equal");
         }
    }
    
    // Multiply matrices option
    public static void optMultiply(){
        // get desired row and column size for matrix 1
        int urows, ucolumns;
        System.out.println("Number of rows for m1: ");
        urows = user_input_int(1,100);
        System.out.println("Number of columns for m1: ");
        ucolumns = user_input_int(1,100);
        
        // fill matrix 1
        Matrix mx = new Matrix(urows,ucolumns);
        fillMatrix(mx);
        
        // get desired row and column size for matrix 2
        System.out.println("Number of rows for m2: ");
        urows = user_input_int(1,100);
        System.out.println("Number of columns for m2: ");
        ucolumns = user_input_int(1,100);
        
        // fill matrix 2
        Matrix mx2 = new Matrix(urows,ucolumns);
        fillMatrix(mx2);
        
        // multply matrices and print result
        boolean noErr;
        noErr = mx.multiplyMatrix(mx2);
        if( noErr ){
            System.out.println("\nResult: \n" + mx.getString());
        } else {
            System.out.println("The number of columns of m1 does not equal the number of rows for m2");
        }
    }
    
    // inverse matrix option
    public static void optInverse(){
        // get desired row and column size
        int urc;
        System.out.println("Number of rows and rows: ");
        urc = user_input_int(2,3);
        
        // fill matrix
        Matrix mx = new Matrix(urc);
        fillMatrix(mx);
        
        // attempt inverse matrix and print result
        boolean noErr;
        noErr = mx.inverse();
        if( noErr ){
            System.out.println("\nResult: \n" + mx.getString());
        } else {
            System.out.println("That matrix has no inverse");
        }
    }
    
    // dot product option
    public static void optDot(){
        
        // create and fill matrix 1
        System.out.println("m1: ");
        Matrix mx = new Matrix(3,1);
        fillMatrix(mx);
        
        // create and fill matrix 2
        System.out.println("m2: ");
        Matrix mx2 = new Matrix(3,1);
        fillMatrix(mx2);
        
        // compute dot product and print result
        int dotProduct;
        dotProduct = mx.dotProduct(mx2);
        System.out.println("\nResult: " + dotProduct);
    }
    
    // cross product option
    public static void optCross(){
        // create and fill matrix 1
        System.out.println("m1: ");  
        Matrix mx = new Matrix(3,1);
        fillMatrix(mx);
        
        // create and fill matrix 2
        System.out.println("m2: ");
        Matrix mx2 = new Matrix(3,1);
        fillMatrix(mx2);
        
        // take cross product and print result
        mx.crossProduct(mx2);
        System.out.println("\nResult: \n" + mx.getString());
    }
    
    // rotate point around x axis option
    public static void optXRotate(){
        // create point
        int px,py,pz;
        System.out.println("x: ");
        px = user_input_int();
        
        System.out.println("y: ");
        py = user_input_int();
        
        System.out.println("z: ");
        pz = user_input_int();
        
        Point3d p1 = new Point3d(px,py,pz);
        
        // get angle to rotate
        int pangle;
        System.out.println("angle to rotate in degrees: ");
        pangle = user_input_int();
        
        // compute and print result
        p1.rotate_x(pangle);
        System.out.println("\nResult: \n" + p1.getString());
    }
    
    // rotate point around y axis option
    public static void optYRotate(){
        // create point
        int px,py,pz;
        System.out.println("x: ");
        px = user_input_int();
        
        System.out.println("y: ");
        py = user_input_int();
        
        System.out.println("z: ");
        pz = user_input_int();
        
        Point3d p1 = new Point3d(px,py,pz);
        
        // get angle to rotate
        int pangle;
        System.out.println("angle to rotate in degrees: ");
        pangle = user_input_int();
        
        // compute and print result
        p1.rotate_y(pangle);
        System.out.println("\nResult: \n" + p1.getString());
    }
    
    // rotate point around z axis option
    public static void optZRotate(){
        // create point
        int px,py,pz;
        System.out.println("x: ");
        px = user_input_int();
        
        System.out.println("y: ");
        py = user_input_int();
        
        System.out.println("z: ");
        pz = user_input_int();
        
        Point3d p1 = new Point3d(px,py,pz);
        
        // get angle to rotate
        int pangle;
        System.out.println("angle to rotate in degrees: ");
        pangle = user_input_int();
        
        // compute and print result
        p1.rotate_z(pangle);
        System.out.println("\nResult: \n" + p1.getString());
    }
    
    // translate point option
    public static void optTranslate(){
        // create point
        int px,py,pz;
        System.out.println("x: ");
        px = user_input_int();
        
        System.out.println("y: ");
        py = user_input_int();
        
        System.out.println("z: ");
        pz = user_input_int();
        
        Point3d p1 = new Point3d(px,py,pz);
        
        // get translation for each coord
        int tx,ty,tz;
        System.out.println("translate x: ");
        tx = user_input_int();
        
        System.out.println("translate y: ");
        ty = user_input_int();
        
        System.out.println("translate z: ");
        tz = user_input_int();
        
        // compute translation and print result
        p1.translate(tx,ty,tz);
        System.out.println("\nResult: \n" + p1.getString());
    }
    
    // scale point option
    public static void optScale(){
        // create point
        int px,py,pz;
        System.out.println("x: ");
        px = user_input_int();
        
        System.out.println("y: ");
        py = user_input_int();
        
        System.out.println("z: ");
        pz = user_input_int();
        
        Point3d p1 = new Point3d(px,py,pz);
        
        // get scale factor for each coord
        double sx,sy,sz;
        System.out.println("scale x: ");
        sx = user_input_double();
        
        System.out.println("scale y: ");
        sy = user_input_double();
        
        System.out.println("scale z: ");
        sz = user_input_double();
        
        // compute and print result
        p1.scale(sx,sy,sz);
        System.out.println("\nResult: \n" + p1.getString());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // infinitely return to main menu
        for(;;){
            mainMenu();
            int selection = user_input_int(0, 11);
            
            // switch for each main menu choice
            switch(selection){
                case 0:
                    System.out.println("Now exiting...");
                    System.exit(1);
                case 1:
                    optTranspose();
                    break;
                case 2:
                    optEquality();
                    break;
                case 3:
                    optMultiply();
                    break;
                case 4:
                    optInverse();
                    break;
                case 5:
                    optDot();
                    break;
                case 6:
                    optCross();
                    break;
                case 7:
                    optXRotate();
                    break;
                case 8:
                    optYRotate();
                    break;
                case 9:
                    optZRotate();
                    break;
                case 10:
                    optTranslate();
                    break;
                case 11:
                    optScale();
            }
        }
    }
}
