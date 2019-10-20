/* 
 * Copyright 2019 Bianca Antonela Glavan - biancaantonela.glavan.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Bianca Antonela Glavan - biancaantonela.glavan.alum@iescamp.es
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();

        // Inicializar constantes cuando empiezan las clases
        final int H_INI = 8;
        final int M_INI = 20;
        final int S_INI = 0;

        //hora actual del sistema(hora máxima)
        int hAct = cal.get(Calendar.HOUR_OF_DAY);
        int mAct = cal.get(Calendar.MINUTE);
        int sAct = cal.get(Calendar.SECOND);

        try {

            //Tiempos > segundos
            int tiempoIni = H_INI * 3600 + M_INI * 60 + S_INI;
            int tiempoAct = hAct * 3600 + mAct * 60 + sAct;
            int tiempoRnd = RND.nextInt(tiempoAct - tiempoIni + 1) + tiempoIni; //Rango entre el tiempo inicial y el tiempo actual
            int tiempoDis = tiempoAct - tiempoRnd;

            //Vuelvo pasar a horas minutos y segundos 
            //Hora aleatoria (Random)
            int hRnd = tiempoRnd / 3600; //pasamos de segundo a horas
            tiempoRnd = tiempoRnd % 3600;
            int mRnd = tiempoRnd / 60; //de segundo a minutos
            int sRnd = tiempoRnd % 60;

            //distancia (sistema)
            int hDis = tiempoDis / 3600;
            tiempoDis = tiempoDis % 3600;
            int mDis = tiempoDis / 60;
            int sDis = tiempoDis % 60;

            //Salidas 
            System.out.printf("Hora actual.......: %02d:%02d:%02d%n", hAct, mAct, sAct);
            System.out.printf("Hora inicio.......:%2d:%2d%02d%n", hRnd, mRnd, sRnd);
            System.out.printf("Tiempo de clase.......:%2d:%2d%02d%n", hDis, mDis, sDis);

        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta");
        }

    }

}
