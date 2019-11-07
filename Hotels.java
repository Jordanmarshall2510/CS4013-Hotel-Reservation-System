/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dermot kind of rioghan jordans geh
 */
public class Hotels {
    
    public Hotels() 
    {
        
    }
    
    
    private String type;


    public Hotels(String aType) {
        this.type = aType;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString()
    {
        return type;
    }
}
    
