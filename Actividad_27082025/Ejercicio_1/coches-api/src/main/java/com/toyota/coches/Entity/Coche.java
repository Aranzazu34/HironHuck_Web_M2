package com.toyota.coches.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "coches")
public class Coche {

    @Id
    //@Column(name = "id_coche")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coche; //standard id es Long (permite null)

    //esto se pone si en la BBDD tiene ese nombre y no el que has definido @Column(name = "nombre")
    private String modelo;
    private String color;
    private Integer num_plazas;
    private Integer id_concesionario;
    private String imagen;

    //por el momento no relacionamos @OneToMany(mappedBy = "coche", cascade = CascadeType.ALL)
    //@JsonManagedReference
    //private List<Coche> coches = new ArrayList<>();

    //@Column(name = "imagen_perfil")
    //private String imagenPerfil;
}

