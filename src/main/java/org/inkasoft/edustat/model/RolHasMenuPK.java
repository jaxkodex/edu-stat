package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_has_menu database table.
 * 
 */
@Embeddable
public class RolHasMenuPK implements Serializable {
    private static final int PRIME = 31;
    private static final int HASH_BASE = 17;
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="rol_id_rol")
    private int rolIdRol;

    @Column(name="menu_id_menu", insertable=false, updatable=false)
    private int menuIdMenu;

    public RolHasMenuPK() {
    }
    public int getRolIdRol() {
        return this.rolIdRol;
    }
    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }
    public int getMenuIdMenu() {
        return this.menuIdMenu;
    }
    public void setMenuIdMenu(int menuIdMenu) {
        this.menuIdMenu = menuIdMenu;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RolHasMenuPK)) {
            return false;
        }
        RolHasMenuPK castOther = (RolHasMenuPK)other;
        return 
            (this.rolIdRol == castOther.rolIdRol)
            && (this.menuIdMenu == castOther.menuIdMenu);
    }

    public int hashCode() {
        final int prime = PRIME;
        int hash = HASH_BASE;
        hash = hash * prime + this.rolIdRol;
        hash = hash * prime + this.menuIdMenu;
        
        return hash;
    }
}