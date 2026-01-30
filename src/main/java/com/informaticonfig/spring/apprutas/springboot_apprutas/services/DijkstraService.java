package com.informaticonfig.spring.apprutas.springboot_apprutas.services;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DijkstraService {

    public ResultadoRuta calcularRuta(String origen, String destino) {

        Map<String, Map<String, Integer>> grafo = new HashMap<>();

        grafo.put("A", Map.of("B", 5, "C", 10));
        grafo.put("B", Map.of("A", 5, "C", 3, "D", 7));
        grafo.put("C", Map.of("A", 10, "B", 3, "D", 1));
        grafo.put("D", Map.of("B", 7, "C", 1));

        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> previo = new HashMap<>();
        PriorityQueue<String> cola =
                new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (String nodo : grafo.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }

        distancias.put(origen, 0);
        cola.add(origen);

        while (!cola.isEmpty()) {
            String actual = cola.poll();

            for (var vecino : grafo.get(actual).entrySet()) {
                int nuevaDist = distancias.get(actual) + vecino.getValue();

                if (nuevaDist < distancias.get(vecino.getKey())) {
                    distancias.put(vecino.getKey(), nuevaDist);
                    previo.put(vecino.getKey(), actual);
                    cola.add(vecino.getKey());
                }
            }
        }

        List<String> ruta = new ArrayList<>();
        for (String at = destino; at != null; at = previo.get(at)) {
            ruta.add(at);
        }
        Collections.reverse(ruta);

        int distancia = distancias.get(destino);
        double combustibleAhorrado = distancia * 0.05;

        return new ResultadoRuta(ruta, distancia, combustibleAhorrado);
    }

    public static class ResultadoRuta {
        private final List<String> ruta;
        private final int distancia;
        private final double combustibleAhorrado;

        public ResultadoRuta(List<String> ruta, int distancia, double combustibleAhorrado) {
            this.ruta = ruta;
            this.distancia = distancia;
            this.combustibleAhorrado = combustibleAhorrado;
        }

        public List<String> getRuta() { return ruta; }
        public int getDistancia() { return distancia; }
        public double getCombustibleAhorrado() { return combustibleAhorrado; }
    }
}
