package edu.math.compoundExpression;

import edu.math.baseFunctions.*;
import edu.math.nextLevelFunctions.*;

public class CompoundSystem {

    private final Log5 log5Fn;
    private final Lg lgFn ;
    private final Ln lnFn ;
    private final Cot cotFn ;
    private final Sec secFn ;
    private final Csc cscFn ;
    private final Sin sinFn ;


    public CompoundSystem(Log5 log5, Ln ln, Lg lg, Cot cot, Sec sec, Csc csc, Sin sin) {
        this.log5Fn = log5;
        this.lgFn = lg;
        this.lnFn = ln;
        this.cotFn = cot;
        this.secFn = sec;
        this.cscFn = csc;
        this.sinFn = sin;
    }


    public double systemSolve(double xValue) throws IllegalArgumentException{
        if (xValue <= 0)
            return trigonometricPart(xValue);
        return logarithmicPart(xValue);
    }

    private double trigonometricPart(double xValue) throws IllegalArgumentException{
        System.out.println("Start solve trigonometric part");
        double cot , sin, sec, csc;
        try{
            cot = cotFn.calculate(xValue);
            sin = sinFn.calculate(xValue);
            sec = secFn.calculate(xValue);
            csc = cscFn.calculate(xValue);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }


        return ((( ( (csc * sin) * sec) / cot) + ((csc / sec) + sec)) + ((sin * sin) * sec));
    }


    private double logarithmicPart(double xValue) throws IllegalArgumentException{
        System.out.println("Start solve logarithmic part");
        double log5, lg, ln;
        log5 = log5Fn.calculate(xValue);
        lg = lgFn.calculate(xValue);
        ln = lnFn.calculate(xValue);
        return (Math.pow( ((((ln * lg) - log5) * ln) - ln), 2));
    }

}