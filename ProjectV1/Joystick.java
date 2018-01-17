import org.bbi.linuxjoy.*;

/**
 * Write a description of class Joystick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joystick  
{
    // instance variables - replace the example below with your own
    private int x;
    LinuxJoystick j;  // get first device
    /**
     * Constructor for objects of class Joystick
     */
    public Joystick()
    {
        int[] joyInfo = JoyFactory.enumerate();
        for(int i=0; i<joyInfo.length; i++){
            System.out.println(i);
        }
        j = JoyFactory.getFirstUsableDevice();
        if(j != null) {
            j.setCallback(new EventCallbackHandler());
            j.startPollingThread(5); // sleep for 5 ms between polls
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getX()
    {
        
        // double x = -1;
        // if(joyInfo != null) {
            // LinuxJoystick j = JoyFactory.get(0);  // get first device
            // j.open();
            // j.startPollingThread(5);
            // x = j.getAxisState(0);
        // }       
        return 0;
    }
}
