
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rioghan 
 */
public class ReservationSystem {
    private Scanner in;
   private static Hotels[] hotel = { new Hotels("5-Star"),
                                   new Hotels("4-Star"),
                                   new Hotels("3-Star") };
   
   private static Room[] room = { new Room("Double"),
                                   new Room("Twin"),
                                   new Room("Single") };
   
   public ReservationSystem()
   {
      this.in = new Scanner(System.in);
   }
   
   
   public void run(Hotels machine)
         throws IOException
   {
      boolean more = true;
      
      while (more)
      { 
         System.out.println("R)eservation  C)ancellation  Q)uit");
         String command = in.nextLine().toUpperCase();

         if (command.equals("R"))
         {  
             getChoice(hotel);
             getChoice(room);
             machine.addReservation(new Reservation(hotel, room), quantity);
         }
         else if (command.equals("C")) 
         {
              
            System.out.println("Description:");
            String description = in.nextLine();
            System.out.println("Price:");
            double price = in.nextDouble();
            System.out.println("Quantity:");
            int quantity = in.nextInt();
            in.nextLine(); // read the new-line character
            machine.removeReservation(new Product(description, price), quantity);
         
         }
        
         else if (command.equals("Q"))
         { 
            more = false;
         }
      }
   }

   private Object getChoice(Object[] choices)
   {
      while (true)
      {
         char c = 'A';
         for (Object choice : choices)
         {
            System.out.println(c + ") " + choice); 
            c++;
         }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < choices.length)
            return choices[n];
      }      
   }
}
