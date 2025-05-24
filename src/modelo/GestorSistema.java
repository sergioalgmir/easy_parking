package modelo;

import java.util.SortedSet;
import java.util.TreeSet;

import modelo.plaza.Plaza;
import modelo.usuario.Cliente;

public class GestorSistema {
	private static SortedSet<Cliente> listaClientes = new TreeSet<Cliente>();
	private static SortedSet<Plaza> listaPlazas = new TreeSet<Plaza>();
	private static SortedSet<Estacionamiento> listaEstacionamientosFinalizados = new TreeSet<Estacionamiento>();
	private static SortedSet<Estacionamiento> listaEstacionamientosActivos = new TreeSet<Estacionamiento>();
	private static SortedSet<Plaza> plazasLibres = new TreeSet<Plaza>();
	private static SortedSet<Plaza> plazasOcupadas = new TreeSet<Plaza>();
	public static SortedSet<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public static SortedSet<Plaza> getListaPlazas() {
		return listaPlazas;
	}
	public static SortedSet<Estacionamiento> getListaEstacionamientosFinalizados() {
		return listaEstacionamientosFinalizados;
	}
	public static SortedSet<Estacionamiento> getListaEstacionamientosActivos() {
		return listaEstacionamientosActivos;
	}
	public static SortedSet<Plaza> getPlazasLibres() {
		return plazasLibres;
	}
	public static SortedSet<Plaza> getPlazasOcupadas() {
		return plazasOcupadas;
	}
	
	
}
