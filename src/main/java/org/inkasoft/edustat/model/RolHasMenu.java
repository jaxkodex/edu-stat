package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the rol_has_menu database table.
 * 
 */
@Entity
@Table(name = "rol_has_menu")
@NamedQuery(name = "RolHasMenu.findAll", query = "SELECT r FROM RolHasMenu r")
public class RolHasMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RolHasMenuPK id;

    // bi-directional many-to-one association to Rol
    @ManyToOne
    @JoinColumn(name = "rol_id_rol", insertable = false, updatable = false)
    private Rol rol;

    public RolHasMenu() {
    }

    public RolHasMenuPK getId() {
        return this.id;
    }

    public void setId(RolHasMenuPK id) {
        this.id = id;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}