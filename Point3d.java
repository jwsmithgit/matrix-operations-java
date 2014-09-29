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
 * 
 */
public class Point3d {
    int x, y, z;
    
    //constructors
    Point3d(){
        x = 0;
        y = 0;
        z = 0;
    }
    Point3d(int a, int b, int c){
        x = a;
        y = b;
        z = c;
    }
    
    //getters
    int get_x(){
        return x;
    }
    
    int get_y(){
        return y;
    }
    
    int get_z(){
        return z;
    }
    
    // setters
    void set_x(int a){
        x = a;
    }
    
    void set_y(int a){
        y = a;
    }
    
    void set_z(int a){
        z = a;
    }
    
    // turns point into printible string
    String getString(){
        String str;
        str = "["+x+"]\n["+y+"]\n["+z+"]\n";
        return str;
    }
    
    // rotate point around x axis
    void rotate_x(int angle){
        double rangle = Math.toRadians(angle);
        int ytemp = y;
        y = (int)((y*Math.cos(rangle)) - (z*Math.sin(rangle)));
        z = (int)((ytemp*Math.sin(rangle)) + (z*Math.cos(rangle)));
    }
    
    // rotate point around y axis
    void rotate_y(int angle){
        double rangle = Math.toRadians(angle);
        int xtemp = x;
        x = (int)((x*Math.cos(rangle)) + (z*Math.sin(rangle)));
        z = (int)(-(xtemp*Math.sin(rangle)) + (z*Math.cos(rangle)));
    }
    
    // rotate point around z axis
    void rotate_z(int angle){
        double rangle = Math.toRadians(angle);
        int xtemp = x;
        x = (int)((x*Math.cos(rangle)) - (y*Math.sin(rangle)));
        y = (int)((xtemp*Math.sin(rangle)) + (y*Math.cos(rangle)));
    }
    
    // translate point
    void translate(int tx, int ty, int tz){
        x = x+tx;
        y = y+ty;
        z = z+tz;
    }
    
    // scale point
    void scale(double sx, double sy, double sz){
        x = (int)(sx*x);
        y = (int)(sy*y);
        z = (int)(sz*z);
    }
}
