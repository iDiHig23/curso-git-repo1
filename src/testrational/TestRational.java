/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrational;

/**
 *
 * @author Usuario
 */
public class TestRational {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rational r1=new Rational(1,2);
        Rational r2=new Rational(1,2);

        
        
//        if(r1.equals(r2)){
//            System.out.println("The rational "+r1.toString()+" and "+r2+" are equals");
//        }else System.out.println("The rational "+r1.toString()+" and "+r2+" aren't equals");
        r1.simplify();
        System.out.println(r1);


        r1.add(r2);
        System.out.println(r1);
        
        r1.substract(r2);
        System.out.println(r1);
        
        r1.multiply(r2);
        System.out.println(r1);
        
        r1.divide(r2);
        System.out.println(r1);
    }
    
}
