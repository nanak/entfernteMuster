package evs2009;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import evs2009.PeerReader.PeerEndpoint;
/**
 * Testklasse zum Testen des PeerReaders mit anderen Werten
 * @author  Patrick Muehl <pmuehl@student.tgm.ac.at>
 *
 */
public class MuepTest {
	/**
	 * Definition der Testmethode
	 * Hier wird aus der peers.csv der test4 "block" geladen und damit weitergearbeitet
	 * es werden die Erreichbarkeit des Sockets und des SOAP gestestet 
	 */
	@Test
	public void testParse() {
		PeerReader r = new PeerReader("peers.csv");
		List<PeerEndpoint> pe = r.getEndpoints("test4");
		assertEquals(2, pe.size());
		
		assertEquals("socket", pe.get(0).getProtocol());
		assertEquals("localhost:45678", pe.get(0).getLocation());
		assertEquals(45678, pe.get(0).getPort());
		
		assertEquals("soap", pe.get(1).getProtocol());
		assertEquals("http://localhost:45679/peer", pe.get(1).getLocation());
		assertEquals(45679, pe.get(1).getPort());
		
	}
}
