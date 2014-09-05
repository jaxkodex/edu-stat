package org.inkasoft.edustat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT u FROM Menu u")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_menu")
	private Integer idMenu;
	@Column(name="menu_nombre")
	private String menuNombre;
	@Column(name="menu_ruta")
	private String menuRuta;
	//private List<Menu> childMenus;
	@ManyToOne
	@JoinColumn(name="menu_id_menu")
	private Menu parentMenu;
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="rol_has_menu", 
			joinColumns = @JoinColumn(name="menu_id_menu"),
			inverseJoinColumns = @JoinColumn(name="rol_id_rol")
	)
	private List<Rol> roles;
	
	/**
	 * @return the idMenu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	/**
	 * @return the menuNombre
	 */
	public String getMenuNombre() {
		return menuNombre;
	}
	/**
	 * @param menuNombre the menuNombre to set
	 */
	public void setMenuNombre(String menuNombre) {
		this.menuNombre = menuNombre;
	}
	/**
	 * @return the menuRuta
	 */
	public String getMenuRuta() {
		return menuRuta;
	}
	/**
	 * @param menuRuta the menuRuta to set
	 */
	public void setMenuRuta(String menuRuta) {
		this.menuRuta = menuRuta;
	}
	/**
	 * @return the parentMenu
	 */
	public Menu getParentMenu() {
		return parentMenu;
	}
	/**
	 * @param parentMenu the parentMenu to set
	 */
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
