package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_menu")
	private int idMenu;

	@Column(name="menu_nombre")
	private String menuNombre;

	@Column(name="menu_ruta")
	private String menuRuta;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	private Menu menu;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="menu")
	private List<Menu> menus;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="menus")
	private List<Rol> rols;

	public Menu() {
	}

	public int getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getMenuNombre() {
		return this.menuNombre;
	}

	public void setMenuNombre(String menuNombre) {
		this.menuNombre = menuNombre;
	}

	public String getMenuRuta() {
		return this.menuRuta;
	}

	public void setMenuRuta(String menuRuta) {
		this.menuRuta = menuRuta;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setMenu(null);

		return menus;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}