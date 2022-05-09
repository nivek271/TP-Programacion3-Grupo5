/* aclaraciones 
 * 		clases que funcionan como objeto
			ListAsignacionEmpleadPretenso guarda un empleadoPretenso con una array de empresas
			ListAsignacionEmpleador guarda una empresa con un array de empleadoPretensos
			
			EmpleadorPuntaje guarda una empresa con el puntaje que obtuvo en las tablas
			EmpleadoPretensPuntaje guarda un empleadoPretenso con el puntaje que obtuvo en las tablas

agencia debe tener los metodo que generen las superListas (todas las empresas con todos sus posibles 
empleados y viceversa)


la clase PuntajeTicketFC y PuntajeTicketCF acceden a la pos a,b y b,a en las tablas

*////PASSARLO A LA DOCUMENTACION///

package paquete;

import java.util.ArrayList;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.Comision;
import modelo.ControlEstadosTicket;
import modelo.EmpleadPretensoPuntaje;
import modelo.EmpleadorPuntaje;
import modelo.ListAsignacionEmpleadPretenso;
import tablas.PuntajeTicket;

import modelo.ListAsignacionEmpleadPretenso;
import modelo.ListAsignacionEmpleador;
<<<<<<< Updated upstream
=======
import modelo.RondaEncuentrosLaborales;

>>>>>>> Stashed changes

public class Agencia
{
	private static Agencia instancia = null;
	private String nombre;

	//no tendria que considerar conservar todas las listas de contratacion que se generan, yaque al ejecutar dos veces se pierde lo anterior
	

	
<<<<<<< Updated upstream
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensos = new ArrayList<EmpleadoPretenso> ();
	
	private ArrayList<Empleador> empleadoresActivos = new ArrayList<Empleador> ();						
	private ArrayList<EmpleadoPretenso> empleadosPretensosActivos = new ArrayList<EmpleadoPretenso> ();
		
=======
	
	private ArrayList<EmpleadoPretenso> listaEmpleadoPretenso = new ArrayList<EmpleadoPretenso>();  ///listas de empleadosPretensos
	private ArrayList<Empleador> listaEmpleadores = new ArrayList<Empleador>();						///lista empleadores
	
>>>>>>> Stashed changes
	private ArrayList<ListAsignacionEmpleador> listAsignacionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listAsignacionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados

	private ArrayList<ListAsignacionEmpleador> listEleccionEmpleador = new ArrayList<ListAsignacionEmpleador>();//lista de empresas con sus posibles empleados ordenados
	private ArrayList<ListAsignacionEmpleadPretenso> listEleccionEmpleadoPretensos = new ArrayList<ListAsignacionEmpleadPretenso>();//lista de empleadosPretenso con sus posibles empresas ordenados
	
	private ArrayList<ListAsignacionEmpleador> listaCoincidencias = new ArrayList<ListAsignacionEmpleador>();;//lista que guarda las coincidencias entre empresa y empleado

<<<<<<< Updated upstream
	 private double saldoAgencia = 0;
	
	private Agencia() {	}
=======
	
	
	private Agencia() {	
		
	}
>>>>>>> Stashed changes
	
	public static Agencia getInstance()
	{
		if (Agencia.instancia == null)
			Agencia.instancia = new Agencia();
		
		return instancia;
	}
	
	public void agregarEmpleador (Empleador empleador) {
		empleadores.add(empleador);
	}
	
	public void agregarEmpleadoPretenso (EmpleadoPretenso empleadoPretenso) {
		empleadosPretensos.add(empleadoPretenso);
	}
	
	
	public double getSaldoAgencia() {
		return saldoAgencia;
	}

	public void setSaldoAgencia(ArrayList<ListAsignacionEmpleador> listaCoincidencias) {
		Comision comision = null;
		this.saldoAgencia+= comision.calculoComision(listaCoincidencias);
	}

	public void generarUsusariosActivos() {
		ControlListasAgencia cla= null;
		empleadosPretensosActivos = cla.filtroTicketActivoEmpleadosPretensos(empleadosPretensos);
		empleadoresActivos  = cla.filtroTicketActivoEmpleadores(empleadores);
	}
	
	public void activarRondaEncuentrosLaborales () {///metodo que genere las listas de asignacion
		ControlListasAgencia cla= null;
		ControlEstadosTicket cet = null;
		listAsignacionEmpleador = cla.generarListAsignacionEmpleador(empleadosPretensosActivos,empleadoresActivos);
		listAsignacionEmpleadoPretensos = cla.generarListAsignacionEmpleadoPretenso(empleadosPretensosActivos,empleadoresActivos);
		
		listaCoincidencias = cla.ListaCoincidencias(listEleccionEmpleador, listEleccionEmpleadoPretensos);
		actualizacionPuntajeUsuario();
		
		cet.finalizarTickets(listaCoincidencias);    				
	}
	
	

	public void actualizacionPuntajeUsuario()
	{
		for(int i=0; i<empleadosPretensosActivos.size(); i++)
		
		{
			
			//analizo estado del ticket 
			if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().getEstado().equals("FINALIZADO"))
				empleadosPretensosActivos.get(i).setPuntajeUsuario(10);
			else
				if(empleadosPretensosActivos.get(i).getTicket().getEstadoTicket().getEstado().equals("CANCELADO"))
					empleadosPretensosActivos.get(i).setPuntajeUsuario(-1);
			
			//analizo Posicion en la listaEmpleados -> necesito un contador de elementos de la lista
			
			int posicion = 0;
			while(posicion < listAsignacionEmpleadoPretensos.size() && listAsignacionEmpleadoPretensos.get(posicion).getEmpleadoPretenso().equals(empleadosPretensosActivos.get(i)))
				posicion++;	
	
			int ult = listAsignacionEmpleadoPretensos.size();
			//como calculo la posicion?
			if(posicion == ult) //ultimo lugar
				empleadosPretensosActivos.get(i).setPuntajeUsuario(-5);
			else 
				if(posicion == 1) //primero
					empleadosPretensosActivos.get(i).setPuntajeUsuario(5);
		}
	
		for(int j=0; j<empleadoresActivos.size(); j++)
		{
	
			if(empleadoresActivos.get(j).getTicket().getEstadoTicket().getEstado().equals("FINALIZADO"))
				empleadoresActivos.get(j).setPuntajeUsuario(50); 
	
			Empleador empresaPos1 = listAsignacionEmpleador.get(1).getEmpleador();
			
			if(empresaPos1.equals(empleadoresActivos.get(j))) //en primer lugar
				empleadoresActivos.get(j).setPuntajeUsuario(10); 
			
			//necesitocontador de elecciones o var booleana que sea true cuando algun empleado lo haya elejido
			int k = 0;
			while(k < listaCoincidencias.size() && listaCoincidencias.get(k).getEmpleador().equals(empleadoresActivos.get(j)))
				k++;
			
			if(k < listaCoincidencias.size())
				if ( listaCoincidencias.get(k).getListEmpleadosPretensos() == null)//sin elecciones
					empleadoresActivos.get(j).setPuntajeUsuario(-20); 
		}
	}

	public boolean login(String nombUsuarioIngresado, String contrasenaIngresada) throws NombreDeUsuarioIncorrectoException, ContrasenaIncorrectaException
	{
		/**
		 * de ser usuario inexistente tira una excpecion
		 * de ser contraseņa erronea tira otra excpecion
		 **/
		int i = 0;
		boolean loginCorrecto = false;
		while (i<this.empleadores.size() && !this.empleadores.get(i).getNombUsuario().equals(nombUsuarioIngresado))
			i++;
		if (i<this.empleadores.size())
		{
			if (this.empleadores.get(i).getContrasenia().equals(contrasenaIngresada))
				loginCorrecto = true;
			else
				throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
		else
		{
			i = 0;
			while (i<this.empleadosPretensos.size() && !this.empleadosPretensos.get(i).getNombUsuario().equals(nombUsuarioIngresado))
				i++;
			if (i<this.empleadosPretensos.size())
			{
				if (this.empleadosPretensos.get(i).getContrasenia().equals(contrasenaIngresada))
					loginCorrecto = true;
				else
					throw new ContrasenaIncorrectaException("Contrasena incorrecta");
			}
			else
				throw new NombreDeUsuarioIncorrectoException("Nombre de Usuario incorrecto");
		}
<<<<<<< Updated upstream
		return loginCorrecto;
	}
}
=======

}

>>>>>>> Stashed changes
