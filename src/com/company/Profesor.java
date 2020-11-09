package com.company;

import java.util.ArrayList;

public class Profesor extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                int i=0;
                synchronized (Main.alumnosPuntuales) {
                    if (!Main.alumnosPuntuales.isEmpty()) {
                            System.out.println("===== Empiezo la desinfección ===== ");
                            for ( i = 0; i < Main.alumnosPuntuales.size(); i++) {
                                System.out.println("El profesor empieza a desinfectar a " + Main.alumnosPuntuales.get(i));
                                Main.alumnosPuntuales.remove(i);
                            }

                        sleep(4000);
                    } else {
                        System.out.println("Espero a que llegen los alumnos ");
                        Main.alumnosPuntuales.notify();
                        Main.alumnosPuntuales.wait();
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
