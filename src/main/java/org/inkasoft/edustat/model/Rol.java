package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_rol")
	private int idRol;

	@Column(name="rol_name")
	private String rolName;

	//bi-directional many-to-one association to RolHasMenu
	/*@OneToMany(mappedBy="rol")
	private List<RolHasMenu> rolHasMenus;*/

	//bi-directional many-to-many association to Menu
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="rol_has_menu"
		, joinColumns={
			@JoinColumn(name="rol_id_rol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="menu_id_menu")
			}
		)
	private List<Menu> menus;

	//bi-directional many-to-many association to Usuario
	@JsonIgnore
	@ManyToMany(mappedBy="rols")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	/*public List<RolHasMenu> getRolHasMenus() {
		return this.rolHasMenus;
	}

	public void setRolHasMenus(List<RolHasMenu> rolHasMenus) {
		this.rolHasMenus = rolHasMenus;
	}*/

	/*public RolHasMenu addRolHasMenus(RolHasMenu rolHasMenus) {
		getRolHasMenus().add(rolHasMenus);
		rolHasMenus.setRol(this);

		return rolHasMenus;
	}

	public RolHasMenu removeRolHasMenus(RolHasMenu rolHasMenus) {
		getRolHasMenus().remove(rolHasMenus);
		rolHasMenus.setRol(null);

		return rolHasMenus;
	}*/

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		if (menus == null) menus = new ArrayList<Menu>();
		this.menus = menus;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}