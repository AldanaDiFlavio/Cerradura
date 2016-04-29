package ar.edu.unlam.tallerweb.cerradura;

import org.junit.Assert;
import org.junit.Test;

public class CerraduraTest {

	@Test
	public void testPasarCodigoAbreCerradura() {
		Cerradura miCerradura = new Cerradura(1234,3);
		Assert.assertTrue(miCerradura.abrir(1234));
	}
	
	@Test
	public void testPasarCodigoErroneoNoAbreCerradura() {
		Cerradura miCerradura = new Cerradura(1234,3);
		Assert.assertFalse(miCerradura.abrir(888));
	}
	
	@Test
	public void testVerificaPuertaAbierta(){
		Cerradura miCerradura=new Cerradura(1234,3);
		miCerradura.abrir(1234);
		Assert.assertTrue(miCerradura.estaAbierta());
	}
	
	@Test
	public void testPuertaCerrada(){
		Cerradura miCerradura = new Cerradura(1234,3);
		miCerradura.abrir(1234);
		miCerradura.cerrar();
		Assert.assertTrue(miCerradura.estaCerrada());
	}
	
	@Test
	public void testVerificaPuertaCerrada(){
		Cerradura miCerradura=new Cerradura(1234,3);
		miCerradura.cerrar();
		Assert.assertTrue(miCerradura.estaCerrada());
	}
	
	@Test
	public void testVerificaPuertaBloqueada(){
		Cerradura miCerradura = new Cerradura(1234,3);
		miCerradura.abrir(798);
		miCerradura.abrir(777);
		miCerradura.abrir(244);		
		Assert.assertTrue(miCerradura.fueBloqueada());
	}
	
	@Test
	public void testCantidadAperturasExitosas(){
		Cerradura miCerradura= new Cerradura(1234,3);
		miCerradura.abrir(1234);
		miCerradura.abrir(1234);
		miCerradura.abrir(1234);
		miCerradura.abrir(1234);
		miCerradura.abrir(1234);
		miCerradura.abrir(1234);
		Integer cantidadEsperada = 6;
		Integer aperturasExitosas = miCerradura.contarAperturasExistosas();
		Assert.assertEquals(aperturasExitosas,cantidadEsperada);
	}
	
	@Test
	public void testCantidadAperturasFallidas(){
		Cerradura miCerradura= new Cerradura(1234,3);
		miCerradura.abrir(234234);
		miCerradura.abrir(1334);
		miCerradura.abrir(7575);
		miCerradura.abrir(58);
		miCerradura.abrir(7475);
		Integer cantidadEsperada = 5;
		Integer aperturasFallidas = miCerradura.contarAperturasFallidas();
		Assert.assertEquals(aperturasFallidas,cantidadEsperada);
	}
}
