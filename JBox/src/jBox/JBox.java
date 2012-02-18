package jBox;

import puntoGit.PuntoGit;

/**
 *
 * @author fermani
 */
public class JBox {

    public JBox() {
        PuntoGit pg = new PuntoGit("/home/fermani/Tesis/GIT/pi/");
        
        pg.init();
    }

    public static void main(String[] args) {
        new JBox();
    }
}
