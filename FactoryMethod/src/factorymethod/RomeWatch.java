/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethod;

/**
 *
 * @author AKravchuk
 */
public class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("XX-XX-XX");
    }
}
