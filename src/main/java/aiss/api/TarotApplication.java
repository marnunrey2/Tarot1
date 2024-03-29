package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import aiss.api.resources.SpreadResource;
import aiss.api.resources.CardResource;
import aiss.api.resources.CustomCardResource;
import aiss.api.resources.GameResource;


public class TarotApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public TarotApplication() {

		singletons.add(SpreadResource.getInstance());
		singletons.add(CardResource.getInstance());
		singletons.add(GameResource.getInstance());
		singletons.add(CustomCardResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

