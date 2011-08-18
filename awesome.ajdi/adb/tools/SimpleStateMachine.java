/**
 * AODA - Aspect Oriented Debugging Architecture
 * Copyright (C) 2007-2009 Wouter De Borger
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package adb.tools;

import adb.InternalDebuggerException;

public class SimpleStateMachine<T extends State> {
	
	public SimpleStateMachine(Action[] acts, T[] states, T current, int[][] transition) {
		super();
		this.acts = acts;
		this.states = states;
		this.current = current;
		this.transition = transition;
	}

	public SimpleStateMachine(){
		
	}
	
	
	private T current;
	private T[] states;
	private Action[] acts;
	//state,action
	private int[][] transition;
	

	public T invoke(Action action) throws InternalDebuggerException{
		int target = transition[current.getId()][action.getId()];
		if(target == -1)
			throw new InternalDebuggerException("can not " + action.getName() + " when " + current.getName());
		current = states[target];
		return current;
	}
	
	public void setStates(T... states){
		this.states = states;
		for (int i = 0; i < states.length; i++) {
			states[i].setId(i);
		}
	}
	
	public void setActions(Action... acts){
		this.acts = acts; 
		for (int i = 0; i < acts.length; i++) {
			acts[i].setId(i);
		}
	}

	public void setInitState(T state){
		current = state;
		transition = new int[states.length][acts.length];
		for (int i = 0; i < states.length; i++) {
			for (int j = 0; j < acts.length; j++) 
				transition[i][j]=-1;
		}
	}
	
	public void setTransition(T from, T to, Action a){
		transition[from.getId()][a.getId()] = to.getId();
	}
	
	public SimpleStateMachine<T> duplicate(){
		return new SimpleStateMachine<T>(acts,states,current,transition);
	}
}
