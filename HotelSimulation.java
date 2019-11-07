
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dermot
 */
public class HotelSimulation {
    public static void main(String[] args)
         throws IOException
   { 
      Hotels machine = new Hotels();
      ReservationSystem reserve = new ReservationSystem();
      reserve.run(machine);
  }
}
