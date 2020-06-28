package rsvflottespeiche;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.naming.Name;
import java.util.Arrays;
import java.util.Collection;


/**
 * 1.
 * Gültige ÄK:
 * 1. Parameter: Länge > 0
 *               .charAt(0) Großbuchstabe
 * 2. Parameter: \([20,60]\)
 * 3. Parameter: -Marathon
 *               -Zeitfahren
 *               -Klassiker
 *               -Rundfahrt
 *               -Triathlon
 *               -Bahn
 * Der erste Parameter muss einen Wert der Länge größer Null haben und mit einem Großbuchstaben beginnen.
 * Jeder Mensch hat erstmal einen Nachnamen und dieser beginnt meistens mit einem Großbuchstaben
 * Der zweite Parameter muss eine Zahl im Bereich von 20-60 (inklusive) sein. Da aus Versicherungstechnischen
 * Gründen nur diese Altersspanne erlaubt ist.
 * Der dritte Parameter darf nur einer der Aufgezählten Möglichkeiten sein. Im Sportverein gibt es nur diese
 * Sportarten.
 *
 * Ungültige ÄK:
 * 1. Parameter: Länge = 0
 *               .charAt(0) kleinbuchstabe
 *               .charAt(0) kein Buchstabe
 * 2. Parameter: x < 20 oder
 *               x > 60
 * 3. Parameter: "alles andere"
 *
 * 2.
 * 1.Parameter: "","kleinerName","123","B","BANANE"
 * 2.Parameter: 19,20,60,61,42,99,1
 * 3.Parameter: Keine Grenzwerte, da genau definiert welche Werte kommen
 *
 * 3.
 *  1. Eingabe: "Dudas",26,"Marathon"   Ausgabe: "D26M"     ÄK: 1. 2. 3.
 *  2. Eingabe: "dudas",26,"Marathon"   Ausgabe: Exception  ÄK: 2. 3. UÄK: 1.2 -> Grenzwert
 *  3. Eingabe: "",26,"Marathon"        Ausgabe: Exception  ÄK: 2. 3. UÄK: 1.1 -> Grenzwert
 *  4. Eingabe: "123",26,"Marathon"     Ausgabe: Exception  ÄK: 2. 3. UÄK: 1.3 -> Grenzwert
 *  5. Eingabe: "Dudas",0,"Marathon"    Ausgabe: Exception  ÄK: 1. 3. UÄK: 2.1
 *  6. Eingabe: "Dudas",100,"Marathon"  Ausgabe: Exception  ÄK: 1. 3. UÄK: 2.2
 *  7. Eingabe: "Dudas",26,"Sprinter"   Ausgabe: Exception  ÄK: 1. 2. UAK: 3.1
 *
 *  8. Eingabe: "Dudas",19,"Marathon"   Ausgabe: Excpetion -> Grenzwert Alter
 *  9. Eingabe: "Dudas",20,"Marathon"   Ausgabe: "D20M" -> Grenzwert Alter
 *  10.Eingabe: "Dudas",60,"Marathon"   Ausgabe: "D60M" -> Grenzwert Alter
 *  11.Eingabe: "Dudas",61,"Marathon"   Ausgabe: Exception -> Grenzwert Alter
 */
@RunWith(Parameterized.class)
public class MitgliederVerwaltungTest {
    MitgliederVerwaltung mitgliederVerwaltung;
    SportartException triathlon;
    SportartException bahn;

    /**
     * Voreinstellung für jeden Test
     */
    @Before
    public void setUp(){
        mitgliederVerwaltung = new MitgliederVerwaltung();
        triathlon = new SportartException("Triathlon");
        bahn = new SportartException("Bahn");
    }
    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public int alter;
    @Parameterized.Parameter(2)
    public SportArt typ;
    @Parameterized.Parameter(3)
    public String erg;

    /**
     * Funktion für parametisierte Tests
     * @return Collection der Parameter
     */
    @Parameterized.Parameters
    public static Collection<Object[]> values() {
        return Arrays.asList(new Object[][]{
                {"Dudas",26,SportArt.Marathon,"D26M"},
                {"Kröger",26,SportArt.Marathon,"K26M"},
                {"Abc",59,SportArt.Marathon,"A59M"}
        });
    }

    /**
     * Testet die NameException
     */
    @Test
    public void testNameException(){
        try{
            mitgliederVerwaltung.beitritt("",21,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (NameException e){
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }

    /**
     * Testet die AlterException
     */
    @Test
    public void testAlterException(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",0,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (AlterException e){
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }

    /**
     * Testet SportArtException auf "Triathlon"
     */
    @Test
    public void testTriathlon(){
        try {
            mitgliederVerwaltung.beitritt("Dudas", 25, SportArt.Triathlon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (SportartException e){
            Assert.assertEquals(e,triathlon);
        } catch (Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }

    /**
     * Testet SportArtException auf "Bahn"
     */
    @Test
    public void testBahn(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",25,SportArt.Bahn);
            Assert.fail("Keine Exception ausgelöst");
        } catch (SportartException e){
            Assert.assertEquals(e,bahn);
        } catch (Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }

    /**
     * Testet ob die Reihenfolge der Exceptionauslösung passt beim NameException und AlterException
     */
    @Test
    public void testReihenfolgeException12(){
        try{
            mitgliederVerwaltung.beitritt("",0,SportArt.Triathlon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (NameException e){
            Assert.assertNotNull(e.getMessage());
        } catch (AlterException | SportartException e){
            Assert.fail("Falsche Reihenfolge!");
        } catch (Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }

    /**
     * Testet ob die Reihenfolge der Exceptionauslösung passt beim AlterException und SportartException
     */
    @Test
    public void testReihenfolgeException23(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",0,SportArt.Triathlon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (AlterException e){
            Assert.assertNotNull(e.getMessage());
        } catch (SportartException e){
            Assert.fail("Falsche Reihenfolge!!");
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testet die Gültigen ÄK über parametisierte Tests
     */
    @Test
    public void testBeitritt(){
        mitgliederVerwaltung = new MitgliederVerwaltung();
        Assert.assertEquals(mitgliederVerwaltung.beitritt(name,alter,typ),erg);
    }

    /**
     * Testfall 2, Großschreibung des Namen
     */
    @Test
    public void test2(){
        try{
            mitgliederVerwaltung.beitritt("dudas",26,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (NameException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testfall 3,Leerer Name
     */
    @Test
    public void test3(){
        try{
            mitgliederVerwaltung.beitritt("",26,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (NameException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testfall 4, Nicht Buchstaben im namen
     */
    @Test
    public void test4(){
        try{
            mitgliederVerwaltung.beitritt("123",26,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (NameException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testfall 5, Alter kleiner als erlaubt
     */
    @Test
    public void test5(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",0,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (AlterException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testfall 6, Alter größer als erlaubt
     */
    @Test
    public void test6(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",100,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (AlterException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }
    // Test7 nicht möglich da Compiler schon meckert

    /**
     * Testfall 8, Grenzwert Alter, knapp drunter
     */
    @Test
    public void test8(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",19,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch (AlterException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e){
            Assert.fail("Falsche Exception geworfen");
        }
    }

    /**
     * Testfall 9, Grenzwert Alter, von Unten knapp drin
     */
    @Test
    public void test9(){
        Assert.assertEquals(mitgliederVerwaltung.beitritt("Dudas",20,SportArt.Marathon),"D20M");
    }

    /**
     * Testfall 10, Grenzwert Alter, Von Oben knapp drin
     */
    @Test
    public void test10(){
        Assert.assertEquals(mitgliederVerwaltung.beitritt("Dudas",60,SportArt.Marathon),"D60M");
    }

    /**
     * Testfall 11, Grenzwert Alter, knapp drüber
     */
    @Test
    public void test11(){
        try{
            mitgliederVerwaltung.beitritt("Dudas",61,SportArt.Marathon);
            Assert.fail("Keine Exception ausgelöst");
        } catch(AlterException e){
            Assert.assertNotNull(e.getMessage());
        } catch(Exception e){
            Assert.fail("Falsche Exception ausgelöst");
        }
    }
}
