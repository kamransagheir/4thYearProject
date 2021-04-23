/*******************************************************************************
 * Copyright (c) 2013-2020 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
package org.eclipse.om2m.smartehealth;

import org.eclipse.om2m.commons.exceptions.BadRequestException;
/**
 * Represent a operation 
 *
 */
public enum Operations {
	
	GET_STATE("getState"),
	GET_STATE_DIRECT("getStateDirect"),
	SET_ON("setOn"),
	SET_OFF("setOff"),
	TOGGLE("toggle"),
	ALL_ON("allOn"),
	ALL_OFF("allOff"),
	ALL_TOGGLE("allToggle");
	private final String value;
	
	private Operations(final String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public String getValue(){
		return value;
	}
	
	/**
	 * Return the operation from the string
	 * @param operation
	 * @return
	 */
	public static Operations getOperationFromString(String operation){
		for(Operations op : values()){
			if(op.getValue().equals(operation)){
				return op;
			}
		}
		throw new BadRequestException("Unknow Operation");
	}
}
