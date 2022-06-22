package prueba;

import java.util.Date;

import excepciones.ContrasenaIncorrectaException;
import excepciones.NombreDeUsuarioIncorrectoException;
import modelo.EstadoTicket;
import modelo.FormularioBusqueda;
import modelo.TicketEmpleadoPretenso;
import modelo.TicketEmpleador;
import paquete.Agencia;
import paquete.Domicilio;
import paquete.EmpleadoPretenso;
import paquete.Empleador;
import paquete.ValoracionAspecto;

public class expLoginUsuario {

	public static void main(String[] args) {
 

		TicketEmpleador ticketEmpleador1 = new TicketEmpleador(new FormularioBusqueda("HomeOffice", "V1", "Completa", "Junior", "Menos de 40", "NADA", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 8, 23), 2, 0);
		TicketEmpleador ticketEmpleador2 = new TicketEmpleador(new FormularioBusqueda("Indistinto", "V2", "Extendida", "Managment", "40 a 50", "MUCHA", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 10, 5), 1, 0);
		TicketEmpleador ticketEmpleador3 = new TicketEmpleador(new FormularioBusqueda("Presencial", "V3", "Media", "Senior", "Mas de 50", "MEDIA", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 7, 12), 3, 0);
		
		Empleador empleador1 = new Empleador(new Domicilio("Juramento", 256, "Casa"), "22356971", "joseyasociados@gmail.com", "JoseyAsociados", "123456789", "Jose y Asociados S.A.", "Comercio Local",  ticketEmpleador1, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10)); //juridica
		Empleador empleador2 = new Empleador(new Domicilio("Alvear", 2978, "9 H"), "7895630", "juana@gmail.com", "JuanaGonzalez", "987456", "Juana Gonzalez", "Salud", ticketEmpleador2, new ValoracionAspecto(10, 10, 10, 10, 10, 10, 10)); //fisica
		Empleador empleador3 = new Empleador(new Domicilio("Luro", 560, "1 A"), "65892150", "raul@gmail.com", "RaulMartinez", "5555555", "Raul Martinez", "Comercio Esterior", ticketEmpleador3, new ValoracionAspecto(5, 5, 5, 5, 5, 5, 5)); //fisica
		
		
		
		
		TicketEmpleadoPretenso ticketEmpleadoPretenso1 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "V1", "Completa", "Senior", "Menos de 40", "MUCHA", "Secundario"), new EstadoTicket("Activo"), new Date(2022, 5, 2));
		TicketEmpleadoPretenso ticketEmpleadoPretenso2 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "V2", "Media", "Managment", "40 a 50", "MEDIA", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 8, 9));
		TicketEmpleadoPretenso ticketEmpleadoPretenso3 = new TicketEmpleadoPretenso(new FormularioBusqueda("Indistinto", "V1", "Extendida", "Junior", "Mas de 50", "NADA", "Primario"), new EstadoTicket("Activo"), new Date(2022, 11, 7));
		TicketEmpleadoPretenso ticketEmpleadoPretenso4 = new TicketEmpleadoPretenso(new FormularioBusqueda("Presencial", "V3", "Extendida", "Managment", "Menos de 40", "MUCHA", "Terciario"), new EstadoTicket("Activo"), new Date(2022, 10, 5));
		TicketEmpleadoPretenso ticketEmpleadoPretenso5 = new TicketEmpleadoPretenso(new FormularioBusqueda("HomeOffice", "V1", "Completa", "Senior", "40 a 50", "MEDIA", "Primario"), new EstadoTicket("Activo"), new Date(2022, 6, 20));
		
		
		EmpleadoPretenso empleadoPretenso1 = new EmpleadoPretenso(new Domicilio("Saavedra", 5842, "Casa"), "552564", "paola@hyty.com", "PaolaArgento", "hola1256", "Paola", "Argento", 34, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso2 = new EmpleadoPretenso(new Domicilio("Mateu", 4563, "7 A"), "999999", "celeste@gmail.com", "CelesteRodriguez", "contrasenia", "Celeste", "Rodriguez", 48, ticketEmpleadoPretenso2);
		EmpleadoPretenso empleadoPretenso3 = new EmpleadoPretenso(new Domicilio("San Luis", 23, "5 F"), "56215", "tatiana@outlook.com", "TatianaAguirre", "asdfasdf", "Tatiana", "Aguirre", 56, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso5 = new EmpleadoPretenso(new Domicilio("Santiago del Estero", 666, "3 I"), "08004556666", "lautaro@gmail.com", "LautaroLazuli", "holahola", "Lautaro", "Lazuli", 42, ticketEmpleadoPretenso1);
		EmpleadoPretenso empleadoPretenso4 = new EmpleadoPretenso(new Domicilio("Calle Falsa", 123, "Casa"), "1565156", "camila@adf.com", "CamilaLopez", "nosequeponer", "Camila", "Lopez", 28, ticketEmpleadoPretenso1);
		
		
		Agencia agencia = new Agencia();
		
		agencia.agregarEmpleador(empleador1);
		agencia.agregarEmpleador(empleador2);
		agencia.agregarEmpleador(empleador3);
		
		
		agencia.agregarEmpleadoPretenso(empleadoPretenso1);
		agencia.agregarEmpleadoPretenso(empleadoPretenso2);
		agencia.agregarEmpleadoPretenso(empleadoPretenso3);
		agencia.agregarEmpleadoPretenso(empleadoPretenso4);
		agencia.agregarEmpleadoPretenso(empleadoPretenso5);
		
		
		System.out.println("Empleadores:");
		agencia.mostrarEmpleadores(agencia.getEmpleadores());
		System.out.println("Empleados pretensos:");
		agencia.mostrarEmpleadosPretensos(agencia.getEmpleadosPretensos());
			
		agencia.generarUsusariosActivos();
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores activos:");
		agencia.mostrarEmpleadores(agencia.getEmpleadoresActivos());
		
		System.out.println("Empleados Pretensos activos:");
		agencia.mostrarEmpleadosPretensos(agencia.getEmpleadosPretensosActivos());
		
		
		
		agencia.activarRondaEncuentrosLaborales();

		
		System.out.println("____________________________________________________");
		System.out.println("Empleados pretensos asignados:");
		for(int i=0; i<agencia.getListAsignacionEmpleador().size(); i++) {
			System.out.println("*******************");
			if (agencia.getListAsignacionEmpleador().get(i).getEmpleador().isPersonaJuridica())
				System.out.println(agencia.getListAsignacionEmpleador().get(i).getEmpleador().getNomRazonS());
			else
				System.out.println(agencia.getListAsignacionEmpleador().get(i).getEmpleador().getNombre()+agencia.getListAsignacionEmpleador().get(i).getEmpleador().getApellido());
			
			for(int j=0; j < agencia.getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(agencia.getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+agencia.getListAsignacionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores asignados:");
		for(int i=0; i<agencia.getListAsignacionEmpleadoPretensos().size(); i++) {
			System.out.println("*******************");
			System.out.println(agencia.getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+agencia.getListAsignacionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido());
			
			for(int j=0; j < agencia.getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
				if (agencia.getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
					System.out.println(agencia.getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
				else
					System.out.println(agencia.getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+agencia.getListAsignacionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
				
			}
		}
		
		
		
		System.out.println("____________________________________________________");
		System.out.println("Empleadores elegidos:");
		for(int i=0; i<agencia.getListEleccionEmpleadoPretensos().size(); i++) {
			System.out.println("*******************");
			System.out.println(agencia.getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getNombre()+agencia.getListEleccionEmpleadoPretensos().get(i).getEmpleadoPretenso().getApellido());
			
			for(int j=0; j < agencia.getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().size(); j++) {
				if (agencia.getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).isPersonaJuridica())
					System.out.println(agencia.getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNomRazonS());
				else
					System.out.println(agencia.getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getNombre()+agencia.getListEleccionEmpleadoPretensos().get(i).getListEmpleadores().get(j).getApellido());
				
			}
		}
		
		System.out.println("Empleados pretensos elegidos:");
		for(int i=0; i<agencia.getListEleccionEmpleador().size(); i++) {
			System.out.println("*******************");
			if (agencia.getListEleccionEmpleador().get(i).getEmpleador().isPersonaJuridica())
				System.out.println(agencia.getListEleccionEmpleador().get(i).getEmpleador().getNomRazonS());
			else
				System.out.println(agencia.getListEleccionEmpleador().get(i).getEmpleador().getNombre()+agencia.getListEleccionEmpleador().get(i).getEmpleador().getApellido());
			
			for(int j=0; j < agencia.getListEleccionEmpleador().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(agencia.getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getNombre()+agencia.getListEleccionEmpleador().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		
		
		System.out.println("____________________________________________________");
		System.out.println("Lista de asignaciones:");
		for(int i=0; i<agencia.getListaCoincidencias().size(); i++) {
			System.out.println("*******************");
			if (agencia.getListaCoincidencias().get(i).getEmpleador().isPersonaJuridica())
				System.out.println(agencia.getListaCoincidencias().get(i).getEmpleador().getNomRazonS());
			else
				System.out.println(agencia.getListaCoincidencias().get(i).getEmpleador().getNombre()+agencia.getListaCoincidencias().get(i).getEmpleador().getApellido());
			
			for(int j=0; j < agencia.getListaCoincidencias().get(i).getListEmpleadosPretensos().size(); j++) {
				System.out.println(agencia.getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getNombre()+agencia.getListaCoincidencias().get(i).getListEmpleadosPretensos().get(j).getApellido());
			}
		}
		
		
		try
		{
			agencia.login("PaolaArgento", "11111");
			System.out.println("Logueo exitoso");
		} catch (NombreDeUsuarioIncorrectoException e)
		{
			System.out.println(e.getMessage());
		} catch (ContrasenaIncorrectaException e)
		{
			System.out.println(e.getMessage());
		}
		

		System.out.println("saldo "+agencia.getSaldoAgencia());
	}

}
