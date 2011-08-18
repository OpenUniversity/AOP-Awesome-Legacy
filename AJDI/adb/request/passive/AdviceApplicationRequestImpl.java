package adb.request.passive;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.request.MethodEntryRequest;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import adb.ShadowMaster;
import ajdi.AdviceApplication;
import ajdi.ObjectReference;
import ajdi.ThreadReference;
import ajdi.request.AdviceAdditionRequest;
import ajdi.request.AdviceApplicationRequest;

public class AdviceApplicationRequestImpl extends EventRequestImpl<MethodEntryRequest> implements AdviceApplicationRequest {

	private AdviceApplication aapl;

	public AdviceApplicationRequestImpl(MethodEntryRequest base, AdviceApplication aapl) {
		super(base, aapl.shadowMaster());
		this.aapl = aapl;
	}

	@Override
	public void addInstanceFilter(ObjectReference instance) {
		base.addInstanceFilter(shadowMaster().unwrap(instance));
	}

	@Override
	public void addThreadFilter(ThreadReference thread) {
		base.addThreadFilter(shadowMaster().unwrap(thread));
	}

	@Override
	public AdviceApplication adviceApplication() {
		return aapl;
	}

}
