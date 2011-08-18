package adb.event.passive;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.MethodEntryEvent;

import adb.ShadowMaster;
import ajdi.Location;
import ajdi.ThreadReference;
import ajdi.event.AdviceApplicationEvent;
import ajdi.request.EventRequest;

public class AdviceApplicationEventImpl extends LocatableEventImpl<MethodEntryEvent> implements AdviceApplicationEvent {

	public AdviceApplicationEventImpl(MethodEntryEvent base, ShadowMaster master) {
		super(base, master);
	}

	
}
