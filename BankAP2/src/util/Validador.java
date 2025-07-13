/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Victor
 */
public class Validador {
    public static boolean isCampoVazio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
    
    public static boolean isEmailValido(String email) {
        if (isCampoVazio(email)) {
            return false;
        }
        return true;
    }
}
