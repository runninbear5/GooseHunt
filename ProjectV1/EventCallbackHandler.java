import org.bbi.linuxjoy.*;
class EventCallbackHandler implements LinuxJoystickEventCallback {
	public void callback(LinuxJoystick j, LinuxJoystickEvent ev) {
		switch(ev.isAxisChanged()) {
			case 0:
				// handle axis 0 change with j.getAxisState(0)
				break;
			case 1:
				// handle axis 1 change with j.getAxisState(1)
				break;
		}

		switch(ev.isButtonDown()) {
			case 0:
				// handle button 0 press here
				break;
			case 1:
				// handle button 1 press here
				break;
		}
		
		switch(ev.isButtonUp()) {
			case 1:
				// handle button 1 release here
				break;
		}
	}
}