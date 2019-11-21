public class MenuPrinter{

    public void printLoginMenu(){
        String [] printOut = {"\n      LOGIN",
                "1.Customer",
                "2.Desk admin",
                "3.Supervisor",
                "4.Exit\n",
                "Please enter your choice: "};

        printMenu(printOut);
    }

    public void printCustomerMenu(){
        String [] printOut =  {"\n      CUSTOMER",
                "1.Reservation",
                "2.Cancellation",
                "3.Log out\n",
                "Please enter your choice: "};

        printMenu(printOut);
    }

    public void printDeskAdministratorMenu(){
        String [] printOut =  {"\n      DESK ADMIN",
                "1.Reservation",
                "2.Cancellation",
                "3.Check out",
                "4.Check in",
                "5.Log out\n",
                "Please enter your choice: "};
        printMenu(printOut);
    }

    public void printSupervisorMenu(){
        String [] printOut = {"\n       SUPERVISOR",
                "1.Reservation",
                "2.Cancellation",
                "3.Check out",
                "4.Check in",
                "5.Discount",
                "6.Data analytics",
                "7.Log out\n",
                "Please enter your choice: "};
        printMenu(printOut);
    }

    public void printAnalyticsMenu(){
        String [] printOut = {"\n       ANALYTICS",
                "1.Hotel occupancy",
                "2.Room occupancy",
                "3.Finance",
                "4.Back\n",
                "Please enter your choice: "};
        printMenu(printOut);
    }

    private void printMenu(String [] menuPrintOut){
        for(int i = 0; i < menuPrintOut.length; i++){
            if(i == menuPrintOut.length - 1){
                System.out.print(menuPrintOut[i]);
            }
            else{
                System.out.println(menuPrintOut[i]);
            }
        }
    }
}
