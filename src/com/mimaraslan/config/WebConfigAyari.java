package com.mimaraslan.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
import com.mimaraslan.ws.MusteriRESTfulService;

public class WebConfigAyari extends Application{

	   private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> empty = new HashSet<Class<?>>();
	 
	   public WebConfigAyari() {
	      singletons.add(new MusteriRESTfulService());
	      //singletons.add(new KursServis());
	      //singletons.add(new KullaniciServis());
	     
	   }
	 
	   @Override
	   public Set<Class<?>> getClasses() {
	      return empty;
	   }
	 
	   @Override
	   public Set<Object> getSingletons() {
	      return singletons;
	   }
}
