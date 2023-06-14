package com.msvc.calificacion.services;


import com.msvc.calificacion.entities.Calificacion;

import java.util.List;

public interface CalificacionService {

    Calificacion create(Calificacion calificacion);

    List<Calificacion> getCalificacioneS();

    List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionByHotelId(String hotelId);

}
