package com.company;

public class Alumno extends Thread {
    public static int i = 0;
    @Override
    public void run() {

        while(true) {
            try {
                synchronized (Main.alumnosPuntuales) {
                    Main.alumnosPuntuales.notify();

                        for (i = 0; i < 6; i++) {
                            String alumno = "Alumno " + i;
                            System.out.println("Ha llegado " + alumno);
                            System.out.println(alumno + " espera a que el profesor le desinfecte");
                            Main.alumnosPuntuales.add(alumno);
                        }

                        sleep(2000);
                    Main.alumnosPuntuales.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
