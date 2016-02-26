/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import facade.Facade;

/**
 *
 * @author Magnus
 */
public class Tester {
    
    public static void main(String[] args) {
       Facade f = new Facade();
        System.out.println(f.findStudentMaxScore().getFirstname());
    }
}
