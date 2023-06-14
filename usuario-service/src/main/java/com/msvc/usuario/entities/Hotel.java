package com.msvc.usuario.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private String id;
    private String nombre;
    private String informacion;
    private String ubicacion;

}
