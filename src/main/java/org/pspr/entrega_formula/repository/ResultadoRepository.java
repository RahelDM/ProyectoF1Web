package org.pspr.entrega_formula.repository;

import org.pspr.entrega_formula.dto.ResultadoDTO;
import org.pspr.entrega_formula.model.Circuito;
import org.pspr.entrega_formula.model.Piloto;
import org.pspr.entrega_formula.model.Resultado;
import org.pspr.entrega_formula.model.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultadoRepository  extends JpaRepository<Resultado, ResultadoId> {

     @Query("FROM Resultado r ORDER BY r.circuito.nombre ASC, r.posicionLlegada ASC")
     List<Resultado> findAllResultadosOrdenados();

     @Query("FROM Resultado r WHERE r.circuito.nombre LIKE %:cadena% OR r.piloto.nombre LIKE %:cadena% OR r.piloto.equipo LIKE %:cadena% ")
     List<Resultado> findResultadosByWord(String cadena);

     //Preguntar
     @Query("""
    SELECT new org.pspr.entrega_formula.dto.ResultadoDTO(r.piloto, 
        SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        )) 
    FROM Resultado r 
    GROUP BY r.piloto 
    ORDER BY  SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        ) DESC 
""")
     List<ResultadoDTO> findPilotosPuntos();



     @Query("""
    SELECT new org.pspr.entrega_formula.dto.ResultadoDTO(r.piloto.equipo, 
        SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        )) 
    FROM Resultado r 
    GROUP BY r.piloto.equipo
    ORDER BY  SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        ) DESC 
""")
     List<ResultadoDTO> findEquiposPuntos();




}
