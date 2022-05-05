package modelo;

import java.util.Date;
import paquete.EmpleadoPretenso;

import paquete.ValoracionAspecto;

public class TicketEmpleador extends Ticket 
{	
	private int cantEmpleadosSolicitados;
	private int cantEmpleadosObtenidos;
	private ArrayList<EmpleadoPretenso> empleadosPretensosMatch = null; //lista se que va a cargar en la ronda de encuentros
	
	
	public TicketEmpleador(FormularioBusqueda fbTicket, EstadoTicket estadoTicket, Date fechaTicket, int cantEmpleadosSolicitados,int cantEmpleadosObtenidos) 
	{
		super(fbTicket, estadoTicket, fechaTicket);
		this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
		this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
	}



	public int getCantEmpleadosSolicitados() {
		return cantEmpleadosSolicitados;
	}



	public void setCantEmpleadosSolicitados(int cantEmpleados) {
		this.cantEmpleadosSolicitados = cantEmpleados;
	}



	public int getCantEmpleadosObtenidos() {
		return cantEmpleadosObtenidos;
	}



	public void setCantEmpleadosObtenidos(int cantEmpleadosObtenidos) {
		this.cantEmpleadosObtenidos = cantEmpleadosObtenidos;
	}
	

	
	
}
