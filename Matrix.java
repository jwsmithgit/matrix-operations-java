/*
 * Jacob Smith
 * V00700979
 * CSC 305
 * Assignment 1
 */
package csc_305_assign1_java;

/**
 *
 * @author jacob
 */
public class Matrix {
    int[][] grid;
    
    // constructors
    // default matrix is 3x3
    Matrix(){
        grid = new int[3][3];
    }
    
    // make matrix with same number of rows and columns
    Matrix(int i){
        grid = new int[i][i];
    }
    
    // make matrix with different number of rows and columns
    Matrix(int i, int j){
        grid = new int[i][j];
    }
    
    // make copy of matrix
    Matrix(Matrix a){
        grid = a.grid;
    }
    
    // get element from matrix
    int getElement(int i, int j){
       int element;
       element = grid[i][j];
       return element;
    }
    
    // set element in matrix
    void setElement(int i, int j, int val){
        grid[i][j] = val;
    }
    
    // size checkers
    // checks if matrix has desired number of rows
    boolean checkRowNum(int a){
        if ( grid.length != a ){
            return false;
        }
        else {
            return true;
        }
    }
    
    // check if matrix has desired number of columns
    boolean checkColNum(int a){
        if ( grid[0].length != a ){
            return false;
        }
        else {
            return true;
        }
    }
    
    // check if matrix has desired size a rows and b columns
    boolean checkSize(int a, int b){
        if ( grid.length != a || grid[0].length != b ){
            return false;
        }
        else {
            return true;
        }
    }
    
    // turn matrix into identity matrix
    boolean makeIdentity(){
        // matrix is not able to turn into identity matrix
        if (grid.length != grid[0].length){
            return false;
        }
        // reset all elements to 0
        int i, j;
        for (i=0; i<grid.length; i++){
            for (j=0; j<grid[0].length; j++){
                grid[i][j] = 0;
            }
        }
        // fill in the 1's
        int k;
        for (k=0; k<grid.length; k++){
            grid[k][k] = 1;
        }
        return true;
    }
    
    
    // returns a string with matrix in printable format
    String getString(){
        String str;
        str = "";
        
        int i, j; // counters
        for (i=0; i<grid.length; i++){
            for (j=0; j<grid[0].length; j++){
                str += "[" + grid[i][j] + "]";
            }
            str += "\n";
        }
        
        return str;
    }
    
    // compares matrix to other matrix for equality
    boolean compareMatrix(Matrix mx){
        //compare size
        if( this.grid.length != mx.grid.length || this.grid[0].length != mx.grid[0].length ){
            return false;
        }
        // same size, test each value
        int i, j;
        for (i=0; i< this.grid.length; i++){
            for (j=0; j< this.grid[0].length; j++){
                if ( this.grid[i][j] != mx.grid[i][j] ){ 
                    return false; 
                }
            }
        }
        // compared each value to be equal, matrix is equal
        return true;
    }
    
    
    // transposes the matrix
    boolean transposeMatrix(){
        // new matrix for transpose
        Matrix mx;
        mx = new Matrix(this.grid[0].length, this.grid.length );
        // go through every value and transpose
        int i, j;
        for (i=0; i< this.grid.length; i++){
            for (j=0; j< this.grid[0].length; j++){
                mx.grid[j][i] = this.grid[i][j];
            }
        }
        
        // transpose of matrix is now in mx
        //return mx;
        
        // transpose of matrix is now in mx
        // assign mx grid to this grid
        this.grid = mx.grid;
        return true;
    }
    
    // multiply the matrix with another matrix
    boolean multiplyMatrix( Matrix mx ){
        // make sure the grid sizes are correct
        if ( this.grid[0].length != mx.grid.length ){
            return false;
        }
        Matrix result;
        result = new Matrix(this.grid.length, mx.grid[0].length);
        int i, j, k;
        for (i=0; i< result.grid.length; i++){
            for (j=0; j< result.grid[0].length; j++){
                // how many numbers to add in each grid element
                for(k=0; k< this.grid[0].length; k++){
                    result.grid[i][j] += (this.grid[i][k] * mx.grid[k][j]);
                }
            }
        }
        
        this.grid = result.grid;
        return true;
    }
    
    // calculates determinant for 2x2 matrix, size must be checked before
    int determinant2(){
        int determinant;
        determinant = ((grid[0][0]*grid[1][1]) - (grid[1][0]*grid[0][1]));
        
        return determinant;
    }
    
    // calculates determinant for 3x3 matrix, size must be checked before
    int determinant3(){
        int dtrmnt1, dtrmnt2, dtrmnt3, determinant;
        int a11,a12,a13,a21,a22,a23,a31,a32,a33;
        a11 = grid[0][0];
        a12 = grid[0][1];
        a13 = grid[0][2];
        a21 = grid[1][0];
        a22 = grid[1][1];
        a23 = grid[1][2];
        a31 = grid[2][0];
        a32 = grid[2][1];
        a33 = grid[2][2];

        dtrmnt1 = a11 * ((a22*a33) - (a23*a32));
        dtrmnt2 = -a12 * ((a21*a33) - (a23*a31));
        dtrmnt3 = a13 * ((a21*a32) - (a22*a31));

        determinant = dtrmnt1 + dtrmnt2 + dtrmnt3;
        return determinant;
    }
    
    // calculates and returns inverse for 2x2 or 3x3 matrix
    boolean inverse(){
        //2x2 matrix inverse
        if( this.grid.length == 2 && grid[0].length == 2){
            int determinant;
            determinant = this.determinant2();
            if( determinant == 0 ){
                return false;
            }
            
            Matrix mx;
            mx = new Matrix(2);
            mx.grid[0][0] = this.grid[1][1] / determinant;
            mx.grid[1][1] = this.grid[0][0] / determinant;
            mx.grid[0][1] = -this.grid[0][1] / determinant;
            mx.grid[1][0] = -this.grid[1][0] / determinant;
            
            this.grid = mx.grid;
            
            return true;
        }
        //3x3 matrix inverse
        if( grid.length == 3 && grid[0].length == 3){
            // get the determinant
            int determinant;
            determinant = this.determinant3();
            //System.out.println(determinant);  
            if( determinant == 0 ){
                return false;
            }
            
            // turn into transpose
            this.transposeMatrix();
            //System.out.println(this.getString());  
            
            // find determinant of 2x2 matrices
            // will hold 2x2 matrix for every spot
            Matrix[][] matrixArr;
            matrixArr = new Matrix[3][3];
            
            // create matrices for each determinant
            int i, j;
            for( i=0; i< matrixArr.length; i++){
                for( j=0; j< matrixArr[0].length; j++){
                    matrixArr[i][j] = new Matrix(2);
                    
                    // put values into each matrix
                    int k,l,m;
                    m = 0;
                    for( k=0; k< this.grid.length; k++){
                        for( l=0; l< this.grid[0].length; l++){
                            if(i != k && j != l){
                                switch(m){
                                    case(0): matrixArr[i][j].grid[0][0] = this.grid[k][l];
                                    case(1): matrixArr[i][j].grid[0][1] = this.grid[k][l];
                                    case(2): matrixArr[i][j].grid[1][0] = this.grid[k][l];
                                    case(3): matrixArr[i][j].grid[1][1] = this.grid[k][l];
                                }
                                m++;
                            }
                        }
                    }
                    
                    //System.out.println(matrixArr[i][j].getString()); 
                    
                }
            }
            
            // apply determinants to our matrix
            for( i=0; i< this.grid.length; i++){
                for( j=0; j< this.grid[0].length; j++){
                    // get determinant value and store in determinant array
                    this.grid[i][j] = matrixArr[i][j].determinant2();

                    if ((i+j)%2 == 1){ this.grid[i][j] = -this.grid[i][j]; }

                    this.grid[i][j] = this.grid[i][j]/determinant;
                }
            }
            
            
            return true;
        }
        
        // not a 2x2 or 3x3 matrix
        return false;
    }
    
    // compute dot product, size will be enforced before function call
    int dotProduct( Matrix mx){
        int i, result;
        result = 0;
        for( i=0; i<this.grid.length; i++){
            result += this.grid[i][0]*mx.grid[i][0];
        }
        return result;
    }
    
    
    // compute cross product, size must be enforced before function call
    void crossProduct( Matrix mx){
        int e1, e2, e3;
        e1 = (this.grid[1][0]*mx.grid[2][0]) - (this.grid[2][0]*mx.grid[1][0]);
        e2 = (this.grid[2][0]*mx.grid[0][0]) - (this.grid[0][0]*mx.grid[2][0]);
        e3 = (this.grid[0][0]*mx.grid[1][0]) - (this.grid[1][0]*mx.grid[0][0]);
        
        this.grid[0][0] = e1;
        this.grid[1][0] = e2;
        this.grid[2][0] = e3;
    }
}
