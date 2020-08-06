/**
 * 
 */
package com.strandls.integrator.controllers;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * 
 * @author vilay
 *
 */
public class IntegratorControllerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IntegratorController.class).in(Scopes.SINGLETON);
	}
}
