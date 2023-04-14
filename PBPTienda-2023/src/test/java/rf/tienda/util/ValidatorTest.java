package rf.tienda.util;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ValidatorTest {
	
	@Test
	public void testAlfaNumericos() {
		assertTrue(Validator.isAlfanumeric("TextoAlfanumerico123"));
		assertFalse(Validator.isAlfanumeric("Texto con espacios"));
		assertFalse(Validator.isAlfanumeric("Texto#ConCaracteres!Especiales"));
	}

	@Test

	public void testIsVacio() {
		assertTrue(Validator.isVacio(""));
		assertFalse(Validator.isVacio("Esto no esta vacio"));
	}

	@Test
	void testCumplePhoneNumber() {
		assertTrue(Validator.cumplePhoneNumber("123456789"));
		assertFalse(Validator.cumplePhoneNumber("12345"));
	}

	@Test
	void testIsEmailValido() {
		assertTrue(Validator.cumplePhoneNumber("123456789"));
		assertFalse(Validator.cumplePhoneNumber("12345"));
	}

	@Test
	void testCumpleDNI() {
		assertTrue(Validator.cumpleDNI("12345678Z"));
		assertFalse(Validator.cumpleDNI("12345678"));
	}

	@Test
	void testCumpleRangoIntIntInt() {
		assertTrue(Validator.cumpleRango(5,1,10));
		assertFalse(Validator.cumpleRango(15,1,10));
	}

	@Test
	void testCumpleRangoDoubleIntInt() {
		assertTrue(Validator.cumpleRango(5,1,10));
		assertFalse(Validator.cumpleRango(15,1,10));
	}

	@Test
	void testCumpleLongitudMin() {
		assertTrue(Validator.cumpleLongitudMin("Hola",4));
		assertFalse(Validator.cumpleLongitudMin("Hola",2));
	}

	@Test
	void testCumpleLongitudMax() {
		assertTrue(Validator.cumpleLongitudMin("Hola",5));
		assertFalse(Validator.cumpleLongitudMin("Hola",3));
	}

	@Test
	void testCumpleLongitud() {
		assertTrue(Validator.cumpleLongitud("Hola",2 ,5));
		assertFalse(Validator.cumpleLongitud("H",2, 5));
	}

	@Test
	void testValDateMin() {
		assertTrue(Validator.valDateMin(LocalDate.parse("2023-04-12"), LocalDate.parse("2001-12-29")));
		assertFalse(Validator.valDateMin(LocalDate.parse("2001-12-29"), LocalDate.parse("2023-04-12")));
	}

	@Test
	void testValDateMax() {
		assertTrue(Validator.valDateMax(LocalDate.parse("2023-04-12"), LocalDate.parse("2077-01-01")));
		assertFalse(Validator.valDateMax(LocalDate.parse("2023-04-12"), LocalDate.parse("2001-12-29")));
	}

	@Test
	void testEsFechaValida() {
		assertTrue(Validator.esFechaValida("2022-04-12"));
		assertTrue(Validator.esFechaValida("2001-12-29"));
		assertTrue(Validator.esFechaValida("2077-01-01"));
		assertFalse(Validator.esFechaValida("12-04-2023"));
		assertFalse(Validator.esFechaValida("2023/04/12"));
		assertFalse(Validator.esFechaValida("2023-04-100"));
		assertFalse(Validator.esFechaValida("2022-100-12"));
		assertFalse(Validator.esFechaValida("100000-04-12"));
	}

	@Test
	void testEsPasswordValida() {
		assertTrue(Validator.esPasswordValida("Prueba1234#"));
		assertFalse(Validator.esPasswordValida("prueba"));
		assertFalse(Validator.esPasswordValida("Prueba1234"));
		assertFalse(Validator.esPasswordValida("Prueba."));
		assertFalse(Validator.esPasswordValida("1234#"));
		assertFalse(Validator.esPasswordValida("PruebasPruebas123456789."));
		assertFalse(Validator.esPasswordValida("Pr1."));
	}

}
