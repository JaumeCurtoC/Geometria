package JUnit.Junit09_Geometria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.Geometria;

class GeometriaTest {

	Geometria g1;
	Geometria g2;
	
	@BeforeEach
	public void before() {
		System.out.println("before");
		g1 = new Geometria();
		g2 = new Geometria(10);
	}
	
	@Test
	public void testAreaCuadrado() {
		System.out.println("TestAreaCuadrado()");
		int result = g1.areacuadrado(5);
		int esperado = 25;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaCirculo() {
		System.out.println("TestAreaCirculo()");
		double result = g1.areaCirculo(5);
		double esperado = 78.54;
		double delta = 1.0;
		assertEquals(esperado, result, delta);
	}
	
	@Test
	public void testAreaTriangulo() {
		System.out.println("TestAreaTriangulo()");
		int result = g1.areatriangulo(5, 10);
		int esperado = 25;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaRectangulo() {
		System.out.println("testAreaRectangulo()");
		int result = g1.arearectangulo(5, 10);
		int esperado = 50;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaPentagono() {
		System.out.println("testAreaPentagono()");
		int result = g1.areapentagono(5, 10);
		int esperado = 25;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaRombo() {
		System.out.println("testAreaRombo()");
		int result = g1.arearombo(5, 10);
		int esperado = 25;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaRomboide() {
		System.out.println("testAreaRomboide()");
		int result = g1.arearomboide(5, 10);
		int esperado = 50;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testAreaTrapecio() {
		System.out.println("testAreaTrapecio()");
		int result = g1.areatrapecio(6,10,5);
		int esperado = 40;
		assertEquals(esperado, result);
	}
	
	private static Stream<Arguments> getFormaFixture() {
		return Stream.of(
				Arguments.of(1, "cuadrado"),
				Arguments.of(2, "Circulo"),
				Arguments.of(3, "Triangulo"),
				Arguments.of(4, "Rectangulo"),
				Arguments.of(5, "Pentagono"),
				Arguments.of(6, "Rombo"),
				Arguments.of(7, "Romboide"),
				Arguments.of(8, "Trapecio")
				);
	}
	
	@ParameterizedTest
	@MethodSource("getFormaFixture")
	public void testFigura(int i, String esperado) {
		System.out.println("testFigura()");
		String result = g1.figura(i);
		assertEquals(esperado, result);
	}
	
	@Test
	public void testGetSetId() {
		System.out.println("testGetSetId()");
		g2.setId(15);
		int result = g2.getId();
		int esperado = 15;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testGetSetNom() {
		System.out.println("testGetSetNom()");
		g2.setNom("Jaume");;
		String result = g2.getNom();
		String esperado = "Jaume";
		assertEquals(esperado, result);
	}
	
	@Test
	public void testGetSetArea() {
		System.out.println("testGetSetArea()");
		g2.setArea(50.0);
		double result = g2.getArea();
		double esperado = 50.0;
		assertEquals(esperado, result);
	}
	
	@Test
	public void testToString() {
		System.out.println("testToString()");
		String result = g2.toString();
		String esperado = "Geometria [id=10, nom=Default, area=0.0]";
		assertEquals(esperado, result);
	}
}
